package example.chain;

import com.typesafe.scalalogging.slf4j.LazyLogging

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbConnect extends ILink, LazyLogging {

  override def hasResource(driverStr: String, connectionStr: String): Boolean = this.hasConnection(connectionStr);

  def hasConnection(connectionStr: String): Boolean =
  {
    var result = false;
    var conn: Connection = null;

    try {
        conn = DriverManager.getConnection(connectionStr);
        result = true;
        logger.info("Success connected to database.");
    } catch {
      case e: SQLException {
        logger.fatal("Fail didn't connect to database.");
      }
    }
    finally {
      if (conn != null)
        conn.close();
    }
    return result;
  }
}
