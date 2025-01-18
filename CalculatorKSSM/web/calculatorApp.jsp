<%@page import="java.util.List"%> <%@page import="bean.calculatorProcess"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  <head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="calc.css" type="text/css" />
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body
    class="h-screen overflow-hidden flex items-center justify-center"
    style="background: #edf2f7"
  >
    <script>
           let currentOperand = "";
           let previousOperand = "";
           let operation = undefined;
      <% calculatorProcess cp = (calculatorProcess) request.getAttribute("calcProcess"); %>
           function appendNumber(number) {
               if(parseFloat(currentOperand) != <%= String.valueOf(cp.getConstraints()).substring(0, String.valueOf(cp.getConstraints()).length()-1) %>){
               if (parseFloat(currentOperand) >= <%= String.valueOf(cp.getConstraints()).substring(0, String.valueOf(cp.getConstraints()).length()-1) %> ) 
                currentOperand = null;
            }
             currentOperand = currentOperand.toString() + number.toString();
             updateDisplay();
           }

           function performOperation(op) {
             if (op === "=") {
               compute();
               return;
             }
             if (currentOperand === "") {
               console.log("no operarand");
               return;
             }
             if (previousOperand !== "") {
               console.log("has operarand");
               compute();
             }
             operation = op;
             previousOperand = currentOperand;
             currentOperand = "";
           }

           function clearAll() {
             currentOperand = "";
             previousOperand = "";
             operation = undefined;
             updateDisplay();
           }

           function compute() {
             console.log("compute function called");
             let computation;
             const prev = parseFloat(previousOperand);
             const current = parseFloat(currentOperand);
             console.log(prev + operation + current);
             if (isNaN(prev) || isNaN(current)) return;
             switch (operation) {
               case "+":
                 computation = prev + current;
                 break;
               case "-":
                   if(prev>current){
                    computation = prev - current;}
                 break;
               case "*":
                 computation = prev * current;
                 break;
               case "/":
                 computation = prev / current;
                 break;
               default:
                 return;
             }
             if(computation > <%= cp.getConstraints() %>)
                computation = undefined;
             currentOperand = computation;
             operation = undefined;
             previousOperand = "";
             updateDisplay();
           }

           function updateDisplay() {
             document.getElementById("screen").innerText = currentOperand;
           }
    </script>
<style>
  @import url(https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.min.css);
</style>


   
      <div
        class="min-w-screen min-h-screen bg-gray-100 flex items-center justify-center px-5 py-5"
      >
      <div className="mb-32 grid text-center lg:max-w-xl lg:w-full lg:mb-0 lg:grid-cols-4 lg:text-left">
          
            <div className="flex flex-row items-center px-20">
              <div>
                <h2 class="text-2xl font-semibold" align="center" >Calculator KSSM</h2>
              </div>
              <div>
                <form
                  class="px-20 mb-3 text-2xl font-semibold"
                  action="calculatorServlet"
                  enctype="multipart/form-data"
                  method="GET"
                  id="myForm"
                >
                  <select name="studentYear" onchange="document.getElementById('myForm').submit()">
                    <option value="1" <% if (cp.getYear() == 1){ %> selected <%}%> >Year 1</option>
                    <option value="2" <% if (cp.getYear() == 2){ %> selected <%}%> >Year 2</option>
                    <option value="3" <% if (cp.getYear() == 3){ %> selected <%}%>>Year 3</option>
                  </select>
                </form>
              </div>
            </div>
      
        <div
          class="w-full mx-auto rounded-xl bg-graytNumberx-100 shadow-xl text-gray-800 relative overflow-hidden"
          style="max-width: 300px"
        >
          <div
            class="w-full h-40 bg-gradient-to-b from-gray-800 to-gray-700 flex items-end text-right"
          >
            <div class="w-full py-5 px-6 text-6xl text-white font-thin">
              <h1 style="padding: 0px" id="screen"></h1>
            </div>
          </div>
          <div class="w-full bg-gradient-to-b from-indigo-400 to-indigo-500">
            <div class="flex w-full">
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button
                  onclick="clearAll()"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-opacity-50 text-xl font-light"
                >
                  C
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-opacity-50 text-xl font-light"
                >
                  
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-opacity-50 text-xl font-light"
                >
                  
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <% if (cp.isShowdivmul()){ %>
                <button onclick="performOperation('/')"
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-10 hover:bg-opacity-20 text-white text-2xl font-light"
                >
                  /
                </button>
                <% } else {%>
                  <button 
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-10 hover:bg-opacity-20 text-white text-2xl font-light"
                >
                </button>
                <%}%>
              </div>
            </div>
            <div class="flex w-full">
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(7)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  7
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(8)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  8
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(9)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  9
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <% if (cp.isShowdivmul()){ %>
                <button onclick="performOperation('*')"
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-10 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  X
                </button>
                <% } else {%>
                  <button
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-10 hover:bg-opacity-20 text-white text-xl font-light"
                >
                </button>
                <%}%>
              </div>
            </div>
            <div class="flex w-full">
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(4)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  4
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(5)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  5
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(6)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  6
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="performOperation('-')"
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-10 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  -
                </button>
              </div>
            </div>
            <div class="flex w-full">
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(1)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  1
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(2)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  2
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="appendNumber(3)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  3
                </button>
              </div>
              <div class="w-1/4 border-r border-b border-indigo-400">
                <button onclick="performOperation('+')"
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-10 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  +
                </button>
              </div>
            </div>
            <div class="flex w-full">
              <div class="w-1/4 border-r border-indigo-400">
                <button onclick="appendNumber(0)"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  0
                </button>
              </div>
              <div class="w-1/4 border-r border-indigo-400">
                <button onclick="appendNumber('.')"
                  class="w-full h-16 outline-none focus:outline-none hover:bg-indigo-700 hover:bg-opacity-20 text-white text-xl font-light"
                >
                  .
                </button>
              </div>
              <div class="w-2/4 border-r border-indigo-400">
                <button onclick="performOperation('=')"
                  class="w-full h-16 outline-none focus:outline-none bg-indigo-700 bg-opacity-30 hover:bg-opacity-40 text-white text-xl font-light"
                >
                  =
                </button>
              </div>
            </div>
          </div>
        </div>

      <!-- <table border="0" cellpadding="3">
        <tbody>
          <tr>
            <td
              colspan="4"
              align="right"
              style="
                padding: 0px;
                margin: 20px;
                background-color: grey;
                height: 50px;
              "
            >
              <h1 style="padding: 0px" id="screen"></h1>
            </td>
            <td>
              <button style="width: 100px" onclick="clearAll()">Clear</button>
            </td>
          </tr>
          </tr>
          <tr>
            <td><button onclick="appendNumber(7)">7</button></td>
            <td><button onclick="appendNumber(8)">8</button></td>
            <td><button onclick="appendNumber(9)">9</button></td>
            <td><button onclick="performOperation('+')">+</button></td>
            
          <tr>
            <td><button onclick="appendNumber(4)">4</button></td>
            <td><button onclick="appendNumber(5)">5</button></td>
            <td><button onclick="appendNumber(6)">6</button></td>
            <td><button onclick="performOperation('-')">-</button></td>
          </tr>
          <tr>
            <td><button onclick="appendNumber(1)">1</button></td>
            <td><button onclick="appendNumber(2)">2</button></td>
            <td><button onclick="appendNumber(3)">3</button></td>
            <% if (cp.isShowdivmul()){ %>
            <td><button onclick="performOperation('*')">*</button></td>
            <% } else {%>
            <td><button onclick=""></button></td>
            <%}%>
          </tr>
          <tr>
            <td><button onclick="appendNumber(0)">0</button></td>
            <td><button onclick="appendNumber('.')">.</button></td>
            <td><button onclick="performOperation('=')">=</button></td>
            <% if (cp.isShowdivmul()){ %>
            <td><button onclick="performOperation('/')">/</button></td>
            <% } else {%>
            <td><button onclick=""></button></td>
            <%}%>
          </tr>
        </tbody>
      </table> -->
    </div>
    </div>
  </body>
</html>
