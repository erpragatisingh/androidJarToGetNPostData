package comviva.mahendra.survey.com.sdktogetdatanpostdata.net;

        import com.android.volley.VolleyError;

/**
 * Created by pragati on 8/18/16.
 *
 *  interface for HTTP request
 */
public interface VolleyInterface {

    public void requestStarted(int requestCode);

    public void requestCompleted(String response, int requestCode);

    public void requestEndedWithError(VolleyError error, int requestCode);
}
