package com.example.test.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author liangxingguo (xingguo.liang@msxf.com).
 */

public class HeadInterceptor implements Interceptor {

  public static final String USER_AGENT = "agent";
  public static final String AGENT_ANDROID = "2";

  public static final String CAANNELNAME = "channelName";
  public static final String CAANNELVALUE = "app";

  public static final String CHANNELPWD = "channelPwd";
  public static final String CHANNELPWDVALUE = "ef538541b0124a6d912af899dde6d57f";

  public static final String VERSION = "version";

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request.Builder builder = chain.request().newBuilder();
    builder.addHeader(USER_AGENT, AGENT_ANDROID);
    builder.addHeader(CAANNELNAME, CAANNELVALUE);
    builder.addHeader(CHANNELPWD, CHANNELPWDVALUE);
    return chain.proceed(builder.build());
  }
}
