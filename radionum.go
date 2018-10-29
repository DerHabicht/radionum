package main

import (
	"fmt"
	//	"io/ioutil"
	"strconv"
	"time"
)

func isValid(n int) bool {
	var d int
	dv := false
	c := false

	for n > 0 {
		if dv && (d == (n % 10)) {
			if c {
				return false
			}
			c = true
		} else {
			dv = true
			c = false
		}

		d = n % 10
		n = n / 10
	}

	return true
}

func GenerateValidNumberList() []int {
	var l []int

	for i := 10; i <= 99; i++ {
		if isValid(i) {
			l = append(l, i)
		}
	}

	for i := 1000; i <= 9999; i++ {
		if isValid(i) {
			l = append(l, i)
		}
	}

	for i := 100000; i <= 999999; i++ {
		if isValid(i) {
			l = append(l, i)
		}
	}

	return l
}

func format(l []int) []byte {
	var fl []byte

	for _, e := range l {
		s := strconv.Itoa(e) + "\n"
		fl = append(fl, []byte(s)...)
	}

	return fl
}

func main() {
	t0 := time.Now()

	_ = GenerateValidNumberList()
	/*
		s := format(l)
		if err := ioutil.WriteFile("valid_station_numbers-go.txt", s, 0644); err != nil {
			panic(err)
		}
	*/

	dt := time.Since(t0)
	fmt.Println(dt)
}
