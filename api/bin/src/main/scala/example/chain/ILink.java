package example.chain;

trait ILink {
  def hasResource(driverStr: String, connectionStr: String): Boolean;
}
