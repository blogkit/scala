import scala.reflect.macros.{Context => Ctx}

object Impls {
  def foo(c: Ctx) = {
    import c.{prefix => prefix}
    import c.universe._
    val printPrefix = Apply(Select(Ident(definitions.PredefModule), TermName("println")), List(Literal(Constant("prefix = " + prefix))))
    val body = Block(List(printPrefix), Literal(Constant("this is deprecated")))
    c.Expr[String](body)
  }
}