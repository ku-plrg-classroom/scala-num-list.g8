package kuplrg

import Implementation.*

class Spec extends SpecBase {

  import Binary.*

  // ---------------------------------------------------------------------------
  // tests for `bigIntNums`
  // ---------------------------------------------------------------------------
  {
    lazy val n = bigIntNums
    import n.*
    val bigInt1: n.Num = 7
    val bigInt2: n.Num = 42
    test(zero, 0)
    test(one, 1)
    test(add(zero, one), 1)
    test(add(bigInt1, bigInt2), 49)
    test(smul(2, one), 2)
    test(smul(3, bigInt1), 21)
    test(smul(5, bigInt2), 210)
    test(mul(bigInt1, bigInt2), 294)
    test(mul(zero, bigInt1), 0)
    test(mul(bigInt2, one), bigInt2)
  }

  // ---------------------------------------------------------------------------
  // tests for `lengthNums`
  // ---------------------------------------------------------------------------
  {
    lazy val l = lengthNums
    import l.*
    val length1: l.Num = "hello"
    val length2: l.Num = "everyone"
    test(zero.length, 0)
    test(one.length, 1)
    test(add(zero, one).length, 1)
    test(add(length1, length2).length, 13)
    test(smul(2, one).length, 2)
    test(smul(3, length1).length, 15)
    test(smul(5, length2).length, 40)
    test(mul(length1, length2).length, 40)
    test(mul(zero, length1).length, 0)
    test(mul(length2, one).length, 8)
  }

  // ---------------------------------------------------------------------------
  // tests for `moduloNums`
  // ---------------------------------------------------------------------------
  {
    lazy val d = moduloNums(13)
    import d.*
    val modulo1: d.Num = 5
    val modulo2: d.Num = 11
    test(zero, 0)
    test(one, 1)
    test(add(zero, one), 1)
    test(add(modulo1, modulo2), 3)
    test(smul(2, one), 2)
    test(smul(3, modulo1), 2)
    test(smul(7, modulo2), 12)
    test(mul(modulo1, modulo2), 3)
    test(mul(zero, modulo1), 0)
    test(mul(modulo2, one), modulo2)
  }

  // ---------------------------------------------------------------------------
  // tests for `binaryNums`
  // ---------------------------------------------------------------------------
  {
    lazy val b = binaryNums
    import b.*
    val bin1: b.Num = Vector(One, Zero, One)
    val bin2: b.Num = Vector(One, Zero, One, Zero, Zero)
    test(zero, Vector.empty)
    test(one, Vector(One))
    test(add(zero, one), Vector(One))
    test(add(bin1, bin2), Vector(One, One, Zero, Zero, One))
    test(smul(2, one), Vector(One, Zero))
    test(smul(3, bin1), Vector(One, One, One, One))
    test(smul(7, bin2), Vector(One, Zero, Zero, Zero, One, One, Zero, Zero))
    test(mul(bin1, bin2), Vector(One, One, Zero, Zero, One, Zero, Zero))
    test(mul(zero, bin1), Vector.empty)
    test(mul(bin2, one), bin2)
  }

  // ---------------------------------------------------------------------------
  // tests for `matrixNums`
  // ---------------------------------------------------------------------------
  {
    lazy val m = matrixNums(3)
    import m.*
    val mat1: m.Num = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9),
    )
    val mat2: m.Num = Vector(
      Vector(2, 13, 1),
      Vector(-3, -5, -1),
      Vector(1, 1, 7),
    )
    test(
      zero,
      Vector(
        Vector(0, 0, 0),
        Vector(0, 0, 0),
        Vector(0, 0, 0),
      ),
    )
    test(
      one,
      Vector(
        Vector(1, 0, 0),
        Vector(0, 1, 0),
        Vector(0, 0, 1),
      ),
    )
    test(add(zero, one), one)
    test(
      add(mat1, mat2),
      Vector(
        Vector(3, 15, 4),
        Vector(1, 0, 5),
        Vector(8, 9, 16),
      ),
    )
    test(
      smul(2, one),
      Vector(
        Vector(2, 0, 0),
        Vector(0, 2, 0),
        Vector(0, 0, 2),
      ),
    )
    test(
      smul(3, mat1),
      Vector(
        Vector(3, 6, 9),
        Vector(12, 15, 18),
        Vector(21, 24, 27),
      ),
    )
    test(
      smul(7, mat2),
      Vector(
        Vector(14, 91, 7),
        Vector(-21, -35, -7),
        Vector(7, 7, 49),
      ),
    )
    test(
      mul(mat1, mat2),
      Vector(
        Vector(-1, 6, 20),
        Vector(-1, 33, 41),
        Vector(-1, 60, 62),
      ),
    )
    test(mul(zero, mat1), zero)
    test(mul(mat2, one), mat2)
  }

  // ---------------------------------------------------------------------------
  // tests for `incs`
  // ---------------------------------------------------------------------------
  {
    lazy val ns1 = { val n = bigIntNums; import n.*; incs(n)(5) }
    test(ns1(42), 47)
    test(ns1(234), 239)

    lazy val ls1 = { val l = lengthNums; import l.*; incs(l)("abc") }
    test(ls1(42).length, 45)
    test(ls1(234).length, 237)

    lazy val ds1 = { val d = moduloNums(13); import d.*; incs(d)(7) }
    test(ds1(42), 10)
    test(ds1(234), 7)

    lazy val bs1 = { val b = binaryNums; import b.*; incs(b)(zero) }
    test(bs1(63), Vector.fill(6)(One))
    val one_zero_16 = One +: Vector.fill(16)(Zero)
    test(bs1(65536), one_zero_16)

    lazy val ms1 = { val m = matrixNums(2); import m.*; incs(m)(smul(3, one)) }
    test(ms1(42), Vector(Vector(45, 0), Vector(0, 45)))
    test(ms1(234), Vector(Vector(237, 0), Vector(0, 237)))
  }

  // ---------------------------------------------------------------------------
  // tests for `squares`
  // ---------------------------------------------------------------------------
  {
    lazy val ns2 = { val n = bigIntNums; import n.*; squares(n) }
    test(ns2(42), 1764)
    test(ns2(234), 54756)

    lazy val ls2 = { val l = lengthNums; import l.*; squares(l) }
    test(ls2(42).length, 1764)
    test(ls2(234).length, 54756)

    lazy val ds2 = { val d = moduloNums(13); import d.*; squares(d) }
    test(ds2(42), 9)
    test(ds2(234), 0)

    lazy val bs2 = { val b = binaryNums; import b.*; squares(b) }
    test(bs2(5), Vector(One, One, Zero, Zero, One))
    test(bs2(11), Vector(One, One, One, One, Zero, Zero, One))

    lazy val ms2 = { val m = matrixNums(2); import m.*; squares(m) }
    test(ms2(42), Vector(Vector(1764, 0), Vector(0, 1764)))
    test(ms2(234), Vector(Vector(54756, 0), Vector(0, 54756)))
  }

  // ---------------------------------------------------------------------------
  // tests for `powers`
  // ---------------------------------------------------------------------------
  {
    lazy val ns3 = { val n = bigIntNums; import n.*; powers(n)(2) }
    test(ns3(5), 32)
    test(ns3(10), 1024)

    lazy val ls3 = { val l = lengthNums; import l.*; powers(l)("aa") }
    test(ls3(5).length, 32)
    test(ls3(10).length, 1024)

    lazy val ds3 = { val d = moduloNums(13); import d.*; powers(d)(2) }
    test(ds3(42), 12)
    test(ds3(234), 12)

    lazy val bs3 = { val b = binaryNums; import b.*; powers(b)(smul(2, one)) }
    test(bs3(5), Vector(One, Zero, Zero, Zero, Zero, Zero))
    val one_zero_42 = One +: Vector.fill(42)(Zero)
    test(bs3(42), one_zero_42)

    lazy val ms3 = {
      val m = matrixNums(2); import m.*;
      powers(m)(Vector(Vector(1, 1), Vector(1, 0)))
    }
    test(ms3(8), Vector(Vector(34, 21), Vector(21, 13)))
    test(ms3(13), Vector(Vector(377, 233), Vector(233, 144)))
  }

  // ---------------------------------------------------------------------------
  // tests for `repeat`
  // ---------------------------------------------------------------------------
  {
    def get(n: Nums)(
      init: n.Num,
      f: (n: Nums) => n.Num => n.Num,
      cache: Boolean,
    ): LazyList[n.Num] =
      import n.*; var k: Num = init; def get: Num = { k = f(n)(k); k }
      repeat(n)(get, cache)
    val T = true
    val F = false
    def inc(n: Nums): n.Num => n.Num = { import n.*; add(_, one) }
    def sqr(n: Nums): n.Num => n.Num = { import n.*; x => mul(x, x) }

    lazy val n = bigIntNums
    test(get(n)(13, inc, T).take(5).toList, List(14, 14, 14, 14, 14))
    test(get(n)(13, inc, F).take(5).toList, List(14, 15, 16, 17, 18))

    lazy val l = lengthNums
    test(get(l)("aa", inc, T).take(5).map(_.length).toList, List(3, 3, 3, 3, 3))
    test(get(l)("aa", inc, F).take(5).map(_.length).toList, List(3, 4, 5, 6, 7))

    lazy val d = moduloNums(13)
    test(get(d)(11, inc, T).take(5).toList, List(12, 12, 12, 12, 12))
    test(get(d)(11, inc, F).take(5).toList, List(12, 0, 1, 2, 3))

    lazy val b = binaryNums
    val b11 = Vector(One, Zero, One, One)
    val b12 = Vector(One, One, Zero, Zero)
    val b13 = Vector(One, One, Zero, One)
    val b14 = Vector(One, One, One, Zero)
    val b15 = Vector(One, One, One, One)
    val b16 = Vector(One, Zero, Zero, Zero, Zero)
    test(get(b)(b11, inc, T).take(5).toList, List(b12, b12, b12, b12, b12))
    test(get(b)(b11, inc, F).take(5).toList, List(b12, b13, b14, b15, b16))

    lazy val m = matrixNums(2)
    val m0: m.Num = Vector(Vector(1, 1), Vector(1, 0))
    val m1: m.Num = Vector(Vector(2, 1), Vector(1, 1))
    val m2: m.Num = Vector(Vector(5, 3), Vector(3, 2))
    val m3: m.Num = Vector(Vector(34, 21), Vector(21, 13))
    val m4: m.Num = Vector(Vector(1597, 987), Vector(987, 610))
    val m5: m.Num = Vector(Vector(3524578, 2178309), Vector(2178309, 1346269))
    test(get(m)(m0, sqr, T).take(5).toList, List(m1, m1, m1, m1, m1))
    test(get(m)(m0, sqr, F).take(5).toList, List(m1, m2, m3, m4, m5))
  }

  // ---------------------------------------------------------------------------
  // tests for `powers`
  // ---------------------------------------------------------------------------
  {
    lazy val ns5 = { val n = bigIntNums; import n.*; weights(n)(3, 2) }
    test(ns5(42), (2, 6, 18))
    test(ns5(234), (18, 3, 60))

    lazy val ls5 = { val l = lengthNums; import l.*; weights(l)("aaa", "aa") }
    test(ls5.map { case (a, b, x) => (a, b, x.length) }(42), (2, 6, 18))
    test(ls5.map { case (a, b, x) => (a, b, x.length) }(234), (18, 3, 60))

    lazy val ds5 = { val d = moduloNums(13); import d.*; weights(d)(3, 2) }
    test(ds5(42), (2, 6, 5))
    test(ds5(234), (18, 3, 8))

    val b2 = Vector(One, Zero)
    val b3 = Vector(One, One)
    val b18 = Vector(One, Zero, Zero, One, Zero)
    val b60 = Vector(One, One, One, One, Zero, Zero)
    lazy val bs5 = { val b = binaryNums; import b.*; weights(b)(b3, b2) }
    test(bs5(42), (2, 6, b18))
    test(bs5(234), (18, 3, b60))

    lazy val ms5 = {
      val m = matrixNums(2); import m.*;
      weights(m)(
        Vector(Vector(2, -3), Vector(7, -6)),
        Vector(Vector(1, 8), Vector(-2, 5)),
      )
    }
    test(ms5(42), (2, 6, Vector(Vector(10, 42), Vector(2, 18))))
    test(ms5(234), (18, 3, Vector(Vector(39, -30), Vector(120, -93))))
  }

  /* Write your own tests */
}
