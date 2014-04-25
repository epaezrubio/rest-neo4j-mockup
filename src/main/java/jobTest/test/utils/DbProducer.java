package jobTest.test.utils;
import jobTest. org.neo4j.graphdb.GraphDatabaseService;


/**
 * Produces a Singletone instance of&nbsp;<span style="color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">GraphDatabaseService. </span><div><span style="color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">In the constructor should call the&nbsp;</span><span style="background-color: rgb(255, 255, 255); color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre;">GraphDatabaseFactory to instantiate a ne EmbeddedDatabase</span><span style="background-color: rgb(255, 255, 255); color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre;">:</span></div><div><span style="color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);"> </span><span class="k" style="box-sizing: border-box; font-weight: bold; color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">new</span><span style="color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);"> </span><span class="n" style="box-sizing: border-box; color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">GraphDatabaseFactory</span><span class="o" style="box-sizing: border-box; font-weight: bold; color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">().</span><span class="na" style="box-sizing: border-box; color: teal; font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">newEmbeddedDatabase</span><span class="o" style="box-sizing: border-box; font-weight: bold; color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">(</span><span style="color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);"> </span><span class="n" style="box-sizing: border-box; color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">db_uri</span><span style="color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);"> </span><span class="o" style="box-sizing: border-box; font-weight: bold; color: rgb(51, 51, 51); font-family: Consolas, 'Liberation Mono', Courier, monospace; font-size: 12px; line-height: 18px; white-space: pre; background-color: rgb(255, 255, 255);">);</span></div>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class DbProducer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String db_path;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private org.neo4j.graphdb.GraphDatabaseService dbService;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public DbProducer(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public org.neo4j.graphdb.GraphDatabaseService getDbService() {
		// TODO : to implement
		return null;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void shutDown() {
		// TODO : to implement	
	}
	
}

