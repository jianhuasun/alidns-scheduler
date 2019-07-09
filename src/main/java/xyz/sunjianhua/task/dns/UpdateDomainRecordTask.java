package xyz.sunjianhua.task.dns;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse.Record;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.google.gson.Gson;

import xyz.sunjianhua.conf.AliDnsConf;
import xyz.sunjianhua.util.HttpUtil;



@Component
public class UpdateDomainRecordTask {

	private Logger logger=LoggerFactory.getLogger(UpdateDomainRecordTask.class);

	@Autowired
	AliDnsConf aliDnsConf;
	
	@Autowired
	IAcsClient client;
	
	// 每隔10s执行一次
    @Scheduled(cron="*/30 * * * * *")
    private void updateDomainRecord(){
        logger.info("定时任务-每天do something -每隔10分钟执行,本次执行开始时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        
//        DefaultProfile profile = DefaultProfile.getProfile(aliDnsConf.getRegionId(), aliDnsConf.getAccessKeyId(),aliDnsConf.getAccessKeySecret());
//        IAcsClient client = new DefaultAcsClient(profile);
        
        try {
        	
        //1. 获取最新外网ip
        	String newIp  = aliDnsConf.getOldIp();
            String ipHtml;
            Pattern pattern = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)");
            Matcher m;
            ipHtml = HttpUtil.httpGet(aliDnsConf.getIpQueryServer());
            if (ipHtml != null) {
                m = pattern.matcher(ipHtml);
                newIp = m.find() ? m.group(1) : newIp;
                if (newIp != null && !newIp.equals(aliDnsConf.getOldIp())) {
                	
                	
                	//2. 获取子域名列表
                    DescribeDomainRecordsRequest domainRecordsRequest = new DescribeDomainRecordsRequest();
                    domainRecordsRequest.setDomainName(aliDnsConf.getRootDomain());
                    DescribeDomainRecordsResponse domainRecordsResponse = client.getAcsResponse(domainRecordsRequest);
                    logger.info("获取子域名列表 : "+new Gson().toJson(domainRecordsResponse));
                	
                    Map<String,String> recordIdMap=new HashMap<>();
                    List<Record> domainRecords=domainRecordsResponse.getDomainRecords();
                    domainRecords.forEach(record->{
                    	
                    	// 只解析配置里的子域名
                        if (Arrays.asList(aliDnsConf.getRefreshDomain().split(",")).contains(record.getRR())) {
                            // 取得要解析的 record id
                        	recordIdMap.put(record.getRecordId(), record.getRR());
                        }
                    });
                    
                    
                    
                    //3. 判断记录值，然后修改
                	UpdateDomainRecordRequest updateDomainRecordRequest = new UpdateDomainRecordRequest();
                	
                	for (String recordId : recordIdMap.keySet()) {
                		updateDomainRecordRequest.setRecordId(recordId);
                		updateDomainRecordRequest.setRR(recordIdMap.get(recordId));
                    	updateDomainRecordRequest.setType("A");
                    	updateDomainRecordRequest.setValue(newIp); 
                    	logger.info("Try Update Domain : " + recordIdMap.get(recordId) + "." + aliDnsConf.getRootDomain() + " , value = "+newIp);
                    	
                    	UpdateDomainRecordResponse response = client.getAcsResponse(updateDomainRecordRequest);
                        logger.info("修改域名记录结果 : "+new Gson().toJson(response));
                	}
                	
                	aliDnsConf.setOldIp(newIp);
                	
                }else {
                	 logger.info("本次ip相同忽略更新 ");
                }
            }
        	
        
        

        
        
       
        
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            logger.info("ErrCode:" + e.getErrCode());
            logger.info("ErrMsg:" + e.getErrMsg());
            logger.info("RequestId:" + e.getRequestId());
        }
	    
        
	    logger.info("定时任务-每天do something -每隔10分钟执行,本次执行结束时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
