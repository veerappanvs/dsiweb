/**
 * 
 */
package ma.dph.dsi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @author vsubramaniyan
 *
 */
@Component
@PropertySources({@PropertySource("classpath:app.properties")})
public class DSIPropertyUtil {

	@Value("${dev}")
	//static String devServer;
	private String devServer="146.243.83.117";
	
	@Value("${uat}")
	 private String uatServer;
	
	@Value("${prod}")
	 private String prodServer;

	/**
	 * @return the devServer
	 */
	public String getDevServer() {
		return devServer;
	}

	/**
	 * @param devServer the devServer to set
	 */
	public void setDevServer(String devServer) {
		this.devServer = devServer;
	}

	/**
	 * @return the uatServer
	 */
	public String getUatServer() {
		return uatServer;
	}

	/**
	 * @param uatServer the uatServer to set
	 */
	public void setUatServer(String uatServer) {
		this.uatServer = uatServer;
	}

	/**
	 * @return the prodServer
	 */
	public String getProdServer() {
		return prodServer;
	}

	/**
	 * @param prodServer the prodServer to set
	 */
	public void setProdServer(String prodServer) {
		this.prodServer = prodServer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DSIPropertyUtil [devServer=" + devServer + ", uatServer=" + uatServer + ", prodServer=" + prodServer
				+ "]";
	}
	
}
