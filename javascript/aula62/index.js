
function* fib(){
    let a = 1; let b = 1;
    while(true) {
        let curr = b;
        b = a;
        a = a + curr;
        const reset = yield curr;
        console.log(reset);
        if(reset) a = b = 1;
    }
}
const sequence = fib();
console.log(sequence.next(false).value);     // 1
console.log(sequence.next('Maça').value);     // 1
console.log(sequence.next().value);     // 2
console.log(sequence.next().value);     // 3
console.log(sequence.next().value);     // 5
console.log(sequence.next(true).value); // 1
console.log(sequence.next().value);     // 1
console.log(sequence.next().value);     // 2
console.log(sequence.next().value);     // 3