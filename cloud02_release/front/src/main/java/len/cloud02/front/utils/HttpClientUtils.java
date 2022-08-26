package len.cloud02.front.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Param;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/18 14:35
 */
public class HttpClientUtils {
    /**
     * 发送post请求
     *
     * @param url       地址
     * @param body      请求体，Object类型支持任意的对象，如支持JSONObject
     * @param headerMap post的请求头headers，如没有参数，则传入null
     * @return 返回值
     */
    public static JSONObject post(String url, Object body, Map<String, String> headerMap) {
        //获取json字符串
        String json = JSON.toJSONString(body);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // 配置post的请求头Header
        if (headerMap != null && headerMap.size() != 0) {
            for (String item : headerMap.keySet()) {
                httpPost.setHeader(item, headerMap.get(item));
            }
        }
        CloseableHttpResponse response;
        try {
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
//            if (response != null && response.getStatusLine().getStatusCode() == 200) {  // 判断stateCode会导致错误信息不返回
            if (response != null) {
                HttpEntity entity = response.getEntity();
                String jsonString = EntityUtils.toString(entity);
                JSONObject jsonObject = JSONObject.parseObject(jsonString);
                return jsonObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 发送get请求
     *
     * @param url       url
     * @param paramMap  get的参数params，如没有参数，则传入null
     * @param headerMap get的请求头headers，如没有参数，则传入null
     * @return {@link JSONObject}
     */
    public static JSONObject get(String url, Map<String, String> paramMap, Map<String, String> headerMap) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 配置get参数Param
            URI uri;
            if (paramMap == null || paramMap.size() == 0) {
                uri = new URI(url);
            } else {
                List<NameValuePair> pairs = new ArrayList<>();
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                URIBuilder builder = new URIBuilder(url).setParameters(pairs);
                uri = builder.build();
            }
            // 生成HttpGet对象
            HttpGet httpGet = new HttpGet(uri);
            // 配置get的请求头Header
            if (headerMap != null && headerMap.size() != 0) {
                for (String item : headerMap.keySet()) {
                    httpGet.setHeader(item, headerMap.get(item));
                }
            }
            // 执行Get请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String jsonString = EntityUtils.toString(entity);
                JSONObject jsonObject = JSONObject.parseObject(jsonString);
                return jsonObject;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String urlAddParams(String url, Map<?, ?> map){
        StringBuilder paramTemp = new StringBuilder("");
        if (map != null){
            paramTemp.append("?");
            for (Object key: map.keySet()){
                if (paramTemp.length()>1){
                    paramTemp.append("&");
                }
                paramTemp.append(key).append("=").append(map.get(key).toString());
            }
        }
        return url+paramTemp;
    }

    public static String paramsToUrl(Param... params){
        StringBuilder paramUrl = new StringBuilder("");
        if (params.length != 0){
            paramUrl.append("?");
            for (Param param: params){
                if (paramUrl.length()>1){
                    paramUrl.append("&");
                }
                paramUrl.append(param.getName()).append("=").append(param.getBody().toString());
            }
        }
        return paramUrl.toString();
    }

    public static void main(String[] args) {
        // 示例：纯Get无参数请求
        JSONObject jsonObject = get("http://127.0.0.1:12003/server/json/getlist", null, null);
        System.out.println(jsonObject);

        // 示例：Get带参数请求
        Map<String, String> param = new HashMap<>();
        param.put("id", "2");
        param.put("host", "100.92.118.33");
        JSONObject jsonObject2 = get("http://127.0.0.1:12003/server/json/takeServer", param, null);
        System.out.println(jsonObject2);
    }
}
