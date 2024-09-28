package kuplrg

object Implementation extends Template {

  lazy val bigIntNums = ???

  lazy val lengthNums = ???

  def moduloNums(mod: Int) =
    if (mod < 2) error(s"The modulo $mod must be greater than 1")
    ???

  lazy val binaryNums = ???

  def matrixNums(n: Int) = ???

  def incs(nums: Nums)(from: nums.Num): LazyList[nums.Num] = ???

  def squares(nums: Nums): LazyList[nums.Num] = ???

  def powers(nums: Nums)(base: nums.Num): LazyList[nums.Num] = ???

  def repeat(nums: Nums)(
    x: => nums.Num,
    cache: Boolean,
  ): LazyList[nums.Num] = ???

  def weights(nums: Nums)(
    x: nums.Num,
    y: nums.Num,
  ): LazyList[(BigInt, BigInt, nums.Num)] = ???
}
