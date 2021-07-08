package examples;

import com.harium.aal.core.action.Action;
import com.harium.aal.core.action.ActionExecutor;
import com.harium.aal.core.engine.AALEngine;
import com.harium.aal.core.engine.JavaRobotEngine;
import com.harium.aal.server.parser.JsonParser;
import com.wizzardo.http.Handler;
import com.wizzardo.http.HttpConnection;
import com.wizzardo.http.HttpServer;
import com.wizzardo.http.request.Request;
import com.wizzardo.http.response.Response;

/**
 * curl -XGET localhost:11011 -d '{"action":"mouse move", "x":300, "y":250}'
 */
public class AALHttpServer {

    public static void main(String[] args) {
        final AALEngine engine = new JavaRobotEngine();
        final JsonParser parser = new JsonParser();

        HttpServer<HttpConnection> server = new HttpServer<>(11011);
        server.getUrlMapping()
                .append("/", new Handler() {
                    @Override
                    public Response handle(Request<HttpConnection, Response> request, Response response) {
                        byte[] data = request.getBody().bytes();
                        Action action = parser.parse(data);
                        ActionExecutor.execute(action, engine);
                        response.setBody("Executed: " + action.action);
                        return response;
                    }
                });
        server.start();
    }

}
