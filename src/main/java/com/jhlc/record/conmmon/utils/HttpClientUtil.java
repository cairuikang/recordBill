package com.jhlc.record.conmmon.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Roy
 * Date: 15-9-9
 * Time: 下午6:48
 */
public class HttpClientUtil {
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * 编码
	 */
	private String encoding = "UTF-8";
    /**
     *     设置请求超时2秒钟 根据业务调整
     */
    private Integer connectionTimeout = 6 * 1000;
    /**
     *     设置等待数据超时时间2秒钟 根据业务调整
     */
    private Integer soTimeout = 60 * 1000;
    /**
     *     该值就是连接不够用的时候等待超时时间，一定要设置，而且不能太大
     */
    private Long connManagerTimeout = 500L;

    public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(Integer soTimeout) {
        this.soTimeout = soTimeout;
    }

    public Long getConnManagerTimeout() {
        return connManagerTimeout;
    }

    public void setConnManagerTimeout(Long connManagerTimeout) {
        this.connManagerTimeout = connManagerTimeout;
    }

    public String getHttp(String url, List<NameValuePair> params, Map<String,String> headers) {
		String responseMsg = "";
		// 1.构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset(encoding);
        httpClient.getParams().setConnectionManagerTimeout(connManagerTimeout);
        httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
		// 2.创建GetMethod的实例
		GetMethod getMethod = new GetMethod(url);
		if(null!=params) {
        getMethod.setQueryString(params.toArray(new NameValuePair[params.size()]));
		}
		// 使用系统系统的默认的恢复策略
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		try {
            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
            managerParams.setConnectionTimeout(connectionTimeout);
            managerParams.setSoTimeout(soTimeout);
            managerParams.setStaleCheckingEnabled(true);//在提交请求之前 测试连接是否可用
			// 设置headers
			if (headers!=null) {
				for (String key : headers.keySet()){
					getMethod.setRequestHeader(key,headers.get(key));
				}
			}

			// 3.执行getMethod,调用http接口
			httpClient.executeMethod(getMethod);
			// 4.读取内容
			responseMsg = getMethod.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 6.释放连接
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
			if (httpClient != null) {
				try {
					((SimpleHttpConnectionManager) httpClient.getHttpConnectionManager()).closeIdleConnections(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
				httpClient = null;
			}
		}
		return responseMsg;
	}

	public String postHttp(String url, List<NameValuePair> params, Map<String,String> headers, String jsonEntity) throws IOException {
		String responseMsg = "";
		// 1.构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset(encoding);
        httpClient.getParams().setConnectionManagerTimeout(connManagerTimeout);
        httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
        // 2.构造PostMethod的实例
		PostMethod postMethod = new PostMethod(url);
		// 3.把参数值放入到PostMethod对象中
		if (params!=null&&!params.isEmpty()){
			postMethod.setRequestBody(params.toArray(new NameValuePair[params.size()]));
		}
		try {
			// 把请求body放入
			if (jsonEntity!=null&&jsonEntity.length()>0){
				RequestEntity entity = new StringRequestEntity(jsonEntity,"application/json","UTF-8");
				postMethod.setRequestEntity(entity);
			}
			// 设置headers
			if (headers!=null) {
				for (String key : headers.keySet()){
					postMethod.setRequestHeader(key,headers.get(key));
				}
			}
			HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
			managerParams.setConnectionTimeout(connectionTimeout);
			managerParams.setSoTimeout(soTimeout);
            managerParams.setStaleCheckingEnabled(true);//在提交请求之前 测试连接是否可用

			// 4.执行postMethod,调用http接口
			httpClient.executeMethod(postMethod);// 200
			// 5.读取内容
			responseMsg = postMethod.getResponseBodyAsString().trim();
		} catch (Exception e) {
            throw e;
		} finally {
			// 7.释放连接
			if (postMethod != null) {
                postMethod.releaseConnection();
            }
			if (httpClient != null) {
				try {
					((SimpleHttpConnectionManager) httpClient.getHttpConnectionManager()).closeIdleConnections(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
				httpClient = null;
			}
		}
		return responseMsg;
	}
	
	
	 public Map getHttpPDF(String url, List<NameValuePair> params, Map<String,String> headers) {
			Map resultMap = new HashMap();
	    	String responseMsg = "";
			// 1.构�?�HttpClient的实�?
			HttpClient httpClient = new HttpClient();
			httpClient.getParams().setContentCharset(encoding);
	        httpClient.getParams().setConnectionManagerTimeout(connManagerTimeout);
	        httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
			// 2.创建GetMethod的实�?
			GetMethod getMethod = new GetMethod(url);
			if(null!=params) {
	        getMethod.setQueryString(params.toArray(new NameValuePair[params.size()]));
			}
			// 使用系统系统的默认的恢复策略
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			try {
	            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
	            managerParams.setConnectionTimeout(connectionTimeout);
	            managerParams.setSoTimeout(soTimeout);
	            managerParams.setStaleCheckingEnabled(true);//在提交请求之�? 测试连接是否可用
				// 设置headers
				if (headers!=null) {
					for (String key : headers.keySet()){
						getMethod.setRequestHeader(key,headers.get(key));
					}
				}
				// 3.执行getMethod,调用http接口
				httpClient.executeMethod(getMethod);
				// 4.读取内容
				InputStream inputStream = getMethod.getResponseBodyAsStream();
				if(null==inputStream) {
				responseMsg = getMethod.getResponseBodyAsString();
				resultMap = JSON.toJavaObject(JSON.parseObject(responseMsg), HashMap.class);
				}else {
				resultMap.put("pdfdata",inputStreamToByte(inputStream));
				}
			} catch (HttpException e) {
				System.out.println(e.getMessage());
				resultMap.put("success", "3");
				resultMap.put("msg", e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				resultMap.put("success", "3");
				resultMap.put("msg", e.getMessage());
			} finally {
				// 6.释放连接
				if (getMethod != null) {
					getMethod.releaseConnection();
				}
				if (httpClient != null) {
					try {
						((SimpleHttpConnectionManager) httpClient.getHttpConnectionManager()).closeIdleConnections(0);
					} catch (Exception e) {
						e.printStackTrace();
					}
					httpClient = null;
				}
			}
			return resultMap;
		}
	 
	 
	 	@SuppressWarnings("unused")
		private static byte[] inputStreamToByte(InputStream is) throws IOException {
			  ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
			  byte[] buffer=new byte[1024];
			  int ch;
			  /**
			   *
			   * */
			  while ((ch = is.read(buffer)) != -1) {
			   bytestream.write(buffer,0,ch);
			  }
			  byte[] data = bytestream.toByteArray();
			  bytestream.close();
			  return data;
	 	} 

}
