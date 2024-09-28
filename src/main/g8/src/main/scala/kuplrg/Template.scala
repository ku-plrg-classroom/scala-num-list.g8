package kuplrg

trait Template {

  /** Number data types */
  trait Nums:
    type Num
    val zero: Num
    val one: Num
    def add(x: Num, y: Num): Num
    def smul(k: BigInt, x: Num): Num
    def mul(x: Num, y: Num): Num

  /** Binary data type */
  enum Binary { case Zero, One }

  def bigIntNums: Nums { type Num = BigInt }
  def lengthNums: Nums { type Num = String }
  def moduloNums(mod: Int): Nums { type Num = BigInt }
  def binaryNums: Nums { type Num = Vector[Binary] }
  def matrixNums(n: Int): Nums { type Num = Vector[Vector[BigInt]] }

  def incs(nums: Nums)(from: nums.Num): LazyList[nums.Num]
  def squares(nums: Nums): LazyList[nums.Num]
  def powers(nums: Nums)(base: nums.Num): LazyList[nums.Num]
  def repeat(nums: Nums)(x: => nums.Num, cache: Boolean): LazyList[nums.Num]
  def weights(nums: Nums)(
    x: nums.Num,
    y: nums.Num,
  ): LazyList[(BigInt, BigInt, nums.Num)]
}
