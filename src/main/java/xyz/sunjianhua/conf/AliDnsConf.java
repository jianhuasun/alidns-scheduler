package xyz.sunjianhua.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

@Configuration
@EnableAutoConfiguration
public class AliDnsConf {

	@Value("${alidns.regionId}")
	private String regionId;

	@Value("${alidns.accessKeyId}")
	private String accessKeyId;

	@Value("${alidns.accessKeySecret}")
	private String accessKeySecret;

	@Value("${alidns.oldIp}")
	private String oldIp;

	@Value("${alidns.rootDomain}")
	private String rootDomain;

	@Value("${alidns.ipQueryServer}")
	private String ipQueryServer;

	@Value("${alidns.refreshDomain}")
	private String refreshDomain;

	
    @Bean
    public IAcsClient getDefaultAcsClient() {
        IClientProfile profile = DefaultProfile.getProfile(getRegionId(), getAccessKeyId(), getAccessKeySecret());
        return new DefaultAcsClient(profile);
    }
	
	
	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getOldIp() {
		return oldIp;
	}

	public void setOldIp(String oldIp) {
		this.oldIp = oldIp;
	}

	public String getRootDomain() {
		return rootDomain;
	}

	public void setRootDomain(String rootDomain) {
		this.rootDomain = rootDomain;
	}

	public String getIpQueryServer() {
		return ipQueryServer;
	}

	public void setIpQueryServer(String ipQueryServer) {
		this.ipQueryServer = ipQueryServer;
	}

	public String getRefreshDomain() {
		return refreshDomain;
	}

	public void setRefreshDomain(String refreshDomain) {
		this.refreshDomain = refreshDomain;
	}

}