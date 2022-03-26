package example.db;

import com.typesafe.scalalogging.slf4j.LazyLogging
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

object DBQuery extends LazyLogging {

  def query(connectionStr: String, tableName: String
    , example.db.print.output.IOutput output) : Unit =
  {
    var conn: Connection = null;
    try {
        conn = DriverManager.getConnection(connectionStr);
        example.db.print.DBTablePrinter.printTable(conn, tableName, output);
        logger.info("Success connected to database.");
    } catch {
      case e: SQLException
        logger.fatal("Fail didn't connect to database.");
    }
    finally {
      if (conn != null) {
        conn.close();
    }
  }
}
