package HW6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Forecast {
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String FORECAST = "forecasts";
    public static final String API_VERSION = "v1";
    public static final String FORECAST_TYPE = "daily";
    public static final String FORECAST_PERIOD = "5day";
    public static final String BATUMI_KEY = "166899";
    public static final String API_KEY = "3zHwEXzfa4FFT7tOvHzjZkBp81axDuyN";

    public static void main(String[] args) throws IOException{
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(BATUMI_KEY)
                .addQueryParameter("apikey",API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
    System.out.println(jsonResponse);
    }
}
