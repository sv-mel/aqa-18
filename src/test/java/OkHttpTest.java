import org.junit.jupiter.api.Test;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class OkHttpTest {

    @Test
    public void shouldCreatePet() throws IOException {
        String baseUrl = "https://petstore.swagger.io/v2";

        OkHttpClient client = new OkHttpClient();

        String str = "{}";
        RequestBody body = RequestBody.create(str.getBytes());

        Request postRequest = new Request.Builder()
                .url(baseUrl + "/pet")
                .post(body)
                .build();

        Call call = client.newCall(postRequest);

        Response response = call.execute();

        assertThat(response.code()).isEqualTo(200);
    }

}
