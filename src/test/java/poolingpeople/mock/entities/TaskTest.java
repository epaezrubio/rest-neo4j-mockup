package poolingpeople.mock.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.rest.graphdb.ExecutingRestRequest;
import org.neo4j.rest.graphdb.RequestResult;
//import org.neo4j.rest.graphdb.RestTestBase;

import poolingpeople.mock.LocalTestServer;
@Ignore
public class TaskTest {

	private GraphDatabaseService restGraphDb;
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 7473;
    private static LocalTestServer neoServer;
    public static final String SERVER_ROOT = "http://" + HOSTNAME + ":" + PORT;
    protected static final String SERVER_ROOT_URI = SERVER_ROOT + "/db/data/";
    private static final String SERVER_CLEANDB_URI = SERVER_ROOT + "/cleandb/secret-key";
    private static final String CONFIG = TaskTest.class.getResource("/neo4j-server.properties").getFile();
    private long referenceNodeId;
    private Node referenceNode;
	
	static {
        initServer();
    }

    protected static void initServer() {
        if (neoServer!=null) {
            neoServer.stop();
        }
        neoServer = new LocalTestServer(HOSTNAME,PORT).withPropertiesFile("neo4j-server.properties");
    }

    @BeforeClass
    public static void startDb() throws Exception {
        neoServer.start();
        tryConnect();
    }
    
    private static void tryConnect() throws InterruptedException {
        int retryCount = 3;
        for (int i = 0; i < retryCount; i++) {
            try {
                RequestResult result = new ExecutingRestRequest(SERVER_ROOT_URI).get("");
                assertEquals(200, result.getStatus());
                System.err.println("Successful HTTP connection to "+SERVER_ROOT_URI);
                return;
            } catch (Exception e) {
                System.err.println("Error retrieving ROOT URI " + e.getMessage());
                Thread.sleep(500);
            }
        }
    }
    
    @After
    public void tearDown() throws Exception {
        restGraphDb.shutdown();
    }

    @AfterClass
    public static void shutdownDb() {
        neoServer.stop();

    }
    
	@Test
	public void testTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbstractEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSerialize() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeserialize() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOrCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

}
