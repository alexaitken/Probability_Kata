Value objects are an important concept in DDD. This kata is made both to learn value objects and to learn better ways of testing.

Write a probability value object. It should contain the following methods:
   Probability CombinedWith(Probability)
   Probability InverseOf(Probability)
   Probability Either(Probability)

if you forget your probability math:
   Either:P(A) + P(B) - P(A)P(B)
   CombinedWith: P(A)P(B)
   InverseOf: 1 - P(A)

The math is surprisingly not the main part of the exercise.

The internal state should be held as a decimal. Use TDD when writing this object.

One last thing. You can't put any getters on the object.  What's the first test to write?

When finished continue reading: https://gist.github.com/1018566