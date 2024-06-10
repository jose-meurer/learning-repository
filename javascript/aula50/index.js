// Arguments

function f() {
  console.log(arguments);
  console.log(arguments["1"]);

  console.log(typeof arguments);
}

f("José", "Miguel", "Valentina");

const funcaoArrow = (...args) => {
  //Maneira mais nova
  console.log(args);
  console.log(args[1]);

  console.log(typeof args);
};

funcaoArrow("José", "Miguel", "Valentina");
