const { performance } = require('perf_hooks');

function isValid(n) {
  d = null;
  c = false;

  while (n > 0) {
    if ((d != null) && (d == (n % 10))) {
      if (c) {
        return false;
      }
      c = true;
    } else {
      c = false;
    }

    d = n % 10;
    n = Math.trunc(n / 10);
  }

  return true;
}

function generateValidNumberList() {
  numberList = [];

  for (var i = 10; i < 99; i++) {
    if (isValid(i)) {
      numberList.push(i);
    }
  }

  for (var i = 1000; i < 9999; i++) {
    if (isValid(i)) {
      numberList.push(i);
    }
  }

  for (var i = 100000; i < 999999; i++) {
    if (isValid(i)) {
      numberList.push(i);
    }
  }

  return numberList;
}

function format(l) {
}

var t0 = performance.now();
generateValidNumberList();
var t1 = performance.now();
var dt = t1 - t0;

console.log(dt);

