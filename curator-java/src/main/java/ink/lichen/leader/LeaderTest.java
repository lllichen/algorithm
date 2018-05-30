package ink.lichen.leader;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lichen@daojia.com on 2018-5-30.
 */
public class LeaderTest {



    public static final String PATH = "/test/leader";

    public static void main(String[] args) throws Exception {

        CuratorFramework client = CuratorFrameworkFactory.newClient( "0.0.0.0:2181",new ExponentialBackoffRetry( 1000,3 ) );

        ExampleClientTest example = new ExampleClientTest( client,PATH,"test" );
        client.start();
        example.start();


        System.out.println("Press enter/return to quit\n");
        new BufferedReader( new InputStreamReader( System.in ) ).readLine();

        CloseableUtils.closeQuietly( client );
        CloseableUtils.closeQuietly( example );
//        CloseableUtils.closeQuietly( server );
    }



}
