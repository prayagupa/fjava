fj
---

attempt to learn and make java functional

data types
-----

- `Semigroup` - TODO
- `Monoid` - TODO
- `Maybe<A>`
```java
var data = new Just<>(1)
        .map(a -> a * 2)
        .fmap(a -> new Just<>(a * 2.0));
```

- `Either<L, R>`
```java
var data = new Right<>(100)
        .map(a -> a * 2 )
        .fmap(a -> new Right<>(a * 3.0));
```
- `List<A>`
```java
var data = List(1, 2, 3, 4)
        .map(a -> a * 2)
        .fmap(c -> List(c * 4));
```
- `Tuple<A, B>` - TODO
- `Void`

- `Task<A>`

```java

var asyncTask = new Task<Integer>(() -> 2)
        .map(data -> data * 2)
        .fmap(data -> new Task<Double>(() -> data * 3.0));
```

reference - http://hackage.haskell.org/package/base-4.12.0.0
