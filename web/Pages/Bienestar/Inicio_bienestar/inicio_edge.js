/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};


var resources = [
];
var symbols = {
"stage": {
   version: "1.5.0",
   minimumCompatibleVersion: "1.5.0",
   build: "1.5.0.217",
   baseState: "Base State",
   initialState: "Base State",
   gpuAccelerate: false,
   resizeInstances: false,
   content: {
         dom: [
         {
            id:'hojas1',
            type:'image',
            rect:['787px','314px','54px','108px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"hojas1.JPG",'0px','0px']
         },
         {
            id:'hojas2',
            type:'image',
            rect:['1086px','317px','50px','108px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"hojas2.JPG",'0px','0px']
         },
         {
            id:'Text',
            type:'text',
            rect:['83px','0px','auto','auto','auto','auto'],
            text:"BIENVENIDOS",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',30,"rgba(0,140,133,1)","normal","none","normal"]
         },
         {
            id:'TextCopy',
            type:'text',
            rect:['277px','0px','395px','auto','auto','auto'],
            text:"AL MODULO BIENESTAR",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',30,"rgba(0,140,133,1)","normal","none","normal"]
         },
         {
            id:'Text5',
            type:'text',
            rect:['461px','134px','auto','auto','auto','auto'],
            text:"CAPELLANIA",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',24,"rgba(0,140,133,1.00)","bold","none","normal"]
         },
         {
            id:'bienestar12',
            type:'image',
            rect:['-300px','51px','300px','200px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"bienestar12.jpg",'0px','0px']
         },
         {
            id:'Text3',
            type:'text',
            rect:['326px','73px','421px','auto','auto','auto'],
            text:"Aqui encontraras servicio de:",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',24,"rgba(0,0,0,1.00)","normal","none","normal"]
         },
         {
            id:'Text4',
            type:'text',
            rect:['453px','111px','auto','auto','auto','auto'],
            text:"PSICOLOGIA",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',24,"rgba(0,140,133,1.00)","700","none","normal"]
         },
         {
            id:'Text6',
            type:'text',
            rect:['434px','170px','auto','auto','auto','auto'],
            text:"ARTE Y CULTURA",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',24,"rgba(0,140,133,1)","700","none","normal"]
         },
         {
            id:'bienestar2',
            type:'image',
            rect:['388px','227px','300px','200px','auto','auto'],
            fill:["rgba(0,0,0,0)",im+"bienestar2.jpg",'0px','0px'],
            transform:[[],[],[],['0.7','0.7']]
         },
         {
            id:'Text2',
            type:'text',
            rect:['39px','244px','361px','auto','auto','auto'],
            text:"El servicio de bienestar e integridad al aprendiz está disponible para todo aquel que desee algún tipo de ayuda o servicio. Te puedes dirigir a nuestras oficinas el cual estaremos en toda la obligación y responsabilidad de atenderte con mucho gusto, porque el bienestar de los aprendices es nuestra prioridad.",
            align:"justify",
            font:['Arial, Helvetica, sans-serif',17,"rgba(0,0,0,1)","normal","none",""]
         },
         {
            id:'Rectangle2',
            type:'rect',
            rect:['754px','2px','6px','422px','auto','auto'],
            fill:["rgba(252,115,35,1.00)"],
            stroke:[0,"rgb(0, 0, 0)","none"]
         },
         {
            id:'Rectangle2Copy2',
            type:'rect',
            rect:['764px','2px','6px','422px','auto','auto'],
            fill:["rgba(252,115,35,1.00)"],
            stroke:[0,"rgb(0, 0, 0)","none"]
         },
         {
            id:'Rectangle2Copy',
            type:'rect',
            rect:['390px','57px','6px','728px','auto','auto'],
            fill:["rgba(252,115,35,1.00)"],
            stroke:[0,"rgb(0, 0, 0)","none"],
            transform:[[],['90']]
         },
         {
            id:'Rectangle2Copy3',
            type:'rect',
            rect:['1108px','61px','6px','687px','auto','auto'],
            fill:["rgba(252,115,35,1.00)"],
            stroke:[0,"rgb(0, 0, 0)","none"],
            transform:[[],['90']]
         },
         {
            id:'TextCopy2',
            type:'text',
            rect:['770px','0px','395px','auto','auto','auto'],
            text:"OBJETIVO GENERAL",
            align:"-webkit-center",
            font:['Arial, Helvetica, sans-serif',30,"rgba(0,140,133,1)","normal","none","normal"]
         },
         {
            id:'Text2Copy',
            type:'text',
            rect:['791px','28px','361px','296px','auto','auto'],
            text:"Contribuir a la formación integral de los alumnos  propiciando condiciones y posibilidades que favorezcan su desarrollo humano en las distintas dimensiones y al  mejoramiento de su calidad de vida como individuos y como grupo institucional; la participación de los alumnos como miembros activos de la comunidad educativa del Servicio Nacional de Aprendizaje, SENA; así mismo,  contribuir en la consolidación de los conocimientos y las competencias adquiridas durante el proceso de aprendizaje, con acciones formativas y  servicios que complementen la integridad de la Formación Profesional.",
            align:"justify",
            font:['Arial, Helvetica, sans-serif',17,"rgba(0,0,0,1)","normal","none",""]
         },
         {
            id:'Text7',
            type:'text',
            rect:['770px','336px','264px','auto','auto','auto'],
            text:"Se llama medio ambiente, porque ya acabamos con la otra mitad.",
            align:"justify",
            font:['Arial, Helvetica, sans-serif',17,"rgba(0,0,0,1)","normal","none","normal"]
         }],
         symbolInstances: [

         ]
      },
   states: {
      "Base State": {
         "${_Rectangle2}": [
            ["color", "background-color", 'rgba(252,115,35,1.00)'],
            ["style", "height", '393px'],
            ["style", "left", '720px'],
            ["style", "top", '-422px']
         ],
         "${_Text7}": [
            ["style", "top", '338px'],
            ["style", "opacity", '0'],
            ["style", "left", '912px'],
            ["style", "width", '264px']
         ],
         "${_bienestar12}": [
            ["style", "top", '51px'],
            ["transform", "scaleY", '0.5'],
            ["transform", "scaleX", '0.5'],
            ["style", "opacity", '0'],
            ["style", "left", '-300px'],
            ["style", "-webkit-transform-origin", [50,50], {valueTemplate:'@@0@@% @@1@@%'} ],
            ["style", "-moz-transform-origin", [50,50],{valueTemplate:'@@0@@% @@1@@%'}],
            ["style", "-ms-transform-origin", [50,50],{valueTemplate:'@@0@@% @@1@@%'}],
            ["style", "msTransformOrigin", [50,50],{valueTemplate:'@@0@@% @@1@@%'}],
            ["style", "-o-transform-origin", [50,50],{valueTemplate:'@@0@@% @@1@@%'}]
         ],
         "${_Text3}": [
            ["style", "top", '-72px'],
            ["style", "font-size", '24px'],
            ["subproperty", "filter.blur", '10px'],
            ["color", "color", 'rgba(0,0,0,1.00)'],
            ["style", "opacity", '1'],
            ["style", "left", '326px'],
            ["style", "width", '421px']
         ],
         "${_Rectangle2Copy3}": [
            ["style", "top", '293px'],
            ["transform", "rotateZ", '90deg'],
            ["style", "height", '0px'],
            ["style", "left", '765px'],
            ["color", "background-color", 'rgba(252,115,35,1)']
         ],
         "${_Text2}": [
            ["style", "top", '440px'],
            ["style", "text-align", 'justify'],
            ["style", "width", '361px'],
            ["style", "opacity", '0'],
            ["style", "left", '39px'],
            ["style", "font-size", '17px']
         ],
         "${_Rectangle2Copy2}": [
            ["style", "height", '404px'],
            ["style", "top", '-404px'],
            ["style", "left", '764px'],
            ["color", "background-color", 'rgba(252,115,35,1)']
         ],
         "${_TextCopy2}": [
            ["style", "top", '109px'],
            ["style", "width", '395px'],
            ["style", "opacity", '0'],
            ["color", "color", 'rgba(0,140,133,1)'],
            ["subproperty", "filter.blur", '0px'],
            ["style", "left", '770px'],
            ["style", "font-size", '24px']
         ],
         "${_Text4}": [
            ["style", "top", '95px'],
            ["color", "color", 'rgba(0,0,0,1.00)'],
            ["style", "font-weight", '700'],
            ["style", "left", '800px'],
            ["style", "opacity", '0']
         ],
         "${_hojas2}": [
            ["style", "top", '361px'],
            ["style", "height", '108px'],
            ["style", "opacity", '0'],
            ["style", "left", '1090px'],
            ["style", "width", '50px']
         ],
         "${_Rectangle2Copy}": [
            ["style", "top", '397px'],
            ["transform", "rotateZ", '90deg'],
            ["style", "height", '0px'],
            ["style", "left", '720px'],
            ["color", "background-color", 'rgba(252,115,35,1.00)']
         ],
         "${_hojas1}": [
            ["style", "top", '358px'],
            ["style", "height", '108px'],
            ["style", "opacity", '0'],
            ["style", "left", '791px'],
            ["style", "width", '54px']
         ],
         "${_Text6}": [
            ["style", "top", '285px'],
            ["style", "font-weight", '700'],
            ["style", "left", '434px'],
            ["style", "opacity", '0']
         ],
         "${_bienestar2}": [
            ["style", "top", '216px'],
            ["transform", "scaleY", '0.2'],
            ["transform", "scaleX", '0.2'],
            ["style", "opacity", '0'],
            ["style", "left", '388px']
         ],
         "${_Text}": [
            ["style", "top", '215px'],
            ["color", "color", 'rgba(255,255,255,1.00)'],
            ["subproperty", "filter.blur", '10px'],
            ["style", "left", '75px'],
            ["style", "opacity", '0']
         ],
         "${_Text2Copy}": [
            ["style", "top", '28px'],
            ["style", "text-align", 'justify'],
            ["style", "font-size", '17px'],
            ["style", "height", '296px'],
            ["style", "opacity", '1'],
            ["style", "left", '1200px'],
            ["style", "width", '361px']
         ],
         "${_Stage}": [
            ["color", "background-color", 'rgba(255,255,255,0.00)'],
            ["style", "width", '1200px'],
            ["style", "height", '440px'],
            ["style", "overflow", 'hidden']
         ],
         "${_Text5}": [
            ["style", "top", '134px'],
            ["color", "color", 'rgba(0,140,133,1.00)'],
            ["style", "opacity", '0.20547945205479'],
            ["style", "left", '141px'],
            ["subproperty", "filter.blur", '10px']
         ],
         "${_TextCopy}": [
            ["style", "top", '197px'],
            ["subproperty", "filter.blur", '10px'],
            ["color", "color", 'rgba(255,255,255,1.00)'],
            ["style", "opacity", '0'],
            ["style", "left", '339px'],
            ["style", "width", '395px']
         ]
      }
   },
   timelines: {
      "Default Timeline": {
         fromState: "Base State",
         toState: "",
         duration: 10500,
         autoPlay: true,
         timeline: [
            { id: "eid215", tween: [ "style", "${_Rectangle2Copy}", "height", '687px', { fromValue: '0px'}], position: 3500, duration: 3000 },
            { id: "eid284", tween: [ "style", "${_hojas1}", "top", '314px', { fromValue: '358px'}], position: 9500, duration: 1000 },
            { id: "eid49", tween: [ "color", "${_TextCopy}", "color", 'rgba(0,140,133,1)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(255,255,255,1.00)'}], position: 0, duration: 1000 },
            { id: "eid244", tween: [ "style", "${_TextCopy2}", "top", '0px', { fromValue: '109px'}], position: 8500, duration: 1000 },
            { id: "eid39", tween: [ "color", "${_Text}", "color", 'rgba(0,140,133,1)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(255,255,255,1.00)'}], position: 0, duration: 1000 },
            { id: "eid256", tween: [ "style", "${_Text7}", "left", '836px', { fromValue: '912px'}], position: 9500, duration: 1000 },
            { id: "eid68", tween: [ "style", "${_TextCopy}", "left", '339px', { fromValue: '339px'}], position: 1000, duration: 0 },
            { id: "eid152", tween: [ "style", "${_TextCopy}", "left", '339px', { fromValue: '339px'}], position: 6500, duration: 0 },
            { id: "eid245", tween: [ "style", "${_TextCopy2}", "opacity", '1', { fromValue: '0'}], position: 8500, duration: 1000 },
            { id: "eid90", tween: [ "style", "${_Text5}", "left", '461px', { fromValue: '141px'}], position: 3000, duration: 1000 },
            { id: "eid151", tween: [ "style", "${_Text5}", "left", '461px', { fromValue: '461px'}], position: 6500, duration: 0 },
            { id: "eid118", tween: [ "style", "${_bienestar2}", "top", '216px', { fromValue: '216px'}], position: 5500, duration: 0 },
            { id: "eid156", tween: [ "style", "${_bienestar2}", "top", '216px', { fromValue: '216px'}], position: 6500, duration: 0 },
            { id: "eid50", tween: [ "style", "${_TextCopy}", "opacity", '1', { fromValue: '0'}], position: 0, duration: 1000 },
            { id: "eid122", tween: [ "style", "${_Text2}", "left", '39px', { fromValue: '39px'}], position: 5500, duration: 0 },
            { id: "eid119", tween: [ "style", "${_Text2}", "left", '39px', { fromValue: '39px'}], position: 6500, duration: 0 },
            { id: "eid101", tween: [ "style", "${_bienestar2}", "left", '388px', { fromValue: '388px'}], position: 5500, duration: 0 },
            { id: "eid146", tween: [ "style", "${_bienestar2}", "left", '388px', { fromValue: '388px'}], position: 6500, duration: 0 },
            { id: "eid240", tween: [ "style", "${_Rectangle2Copy3}", "left", '955px', { fromValue: '765px'}], position: 7500, duration: 1000 },
            { id: "eid99", tween: [ "style", "${_Text6}", "opacity", '1', { fromValue: '0'}], position: 3500, duration: 1000 },
            { id: "eid135", tween: [ "style", "${_Rectangle2Copy}", "left", '380px', { fromValue: '720px'}], position: 3500, duration: 3000 },
            { id: "eid143", tween: [ "style", "${_Rectangle2}", "height", '404px', { fromValue: '393px'}], position: 3500, duration: 3000 },
            { id: "eid67", tween: [ "transform", "${_bienestar12}", "scaleY", '0.8', { fromValue: '0.5'}], position: 1000, duration: 1000 },
            { id: "eid282", tween: [ "style", "${_hojas2}", "top", '317px', { fromValue: '361px'}], position: 9500, duration: 1000 },
            { id: "eid117", tween: [ "transform", "${_bienestar2}", "scaleY", '0.8', { fromValue: '0.2'}], position: 4000, duration: 1500 },
            { id: "eid278", tween: [ "style", "${_hojas1}", "opacity", '1', { fromValue: '0'}], position: 9500, duration: 1000 },
            { id: "eid41", tween: [ "style", "${_Text}", "opacity", '1', { fromValue: '0'}], position: 0, duration: 1000 },
            { id: "eid57", tween: [ "style", "${_bienestar12}", "opacity", '1', { fromValue: '0'}], position: 1000, duration: 1000 },
            { id: "eid116", tween: [ "transform", "${_bienestar2}", "scaleX", '0.8', { fromValue: '0.2'}], position: 4000, duration: 1500 },
            { id: "eid48", tween: [ "subproperty", "${_TextCopy}", "filter.blur", '0px', { fromValue: '10px'}], position: 0, duration: 1000 },
            { id: "eid141", tween: [ "style", "${_Rectangle2}", "left", '720px', { fromValue: '720px'}], position: 0, duration: 3500 },
            { id: "eid145", tween: [ "style", "${_Rectangle2}", "left", '720px', { fromValue: '720px'}], position: 6500, duration: 0 },
            { id: "eid251", tween: [ "style", "${_Text2Copy}", "opacity", '1', { fromValue: '1'}], position: 9500, duration: 0 },
            { id: "eid129", tween: [ "style", "${_Rectangle2}", "top", '2px', { fromValue: '-422px'}], position: 0, duration: 3500 },
            { id: "eid155", tween: [ "style", "${_Rectangle2}", "top", '2px', { fromValue: '2px'}], position: 6500, duration: 0 },
            { id: "eid238", tween: [ "style", "${_Rectangle2Copy3}", "height", '388px', { fromValue: '0px'}], position: 7500, duration: 1000 },
            { id: "eid247", tween: [ "style", "${_TextCopy2}", "font-size", '24px', { fromValue: '24px'}], position: 8677, duration: 0 },
            { id: "eid252", tween: [ "style", "${_Text2Copy}", "left", '791px', { fromValue: '1200px'}], position: 8500, duration: 1000 },
            { id: "eid38", tween: [ "style", "${_Text}", "left", '137px', { fromValue: '75px'}], position: 0, duration: 1000 },
            { id: "eid153", tween: [ "style", "${_Text}", "left", '137px', { fromValue: '137px'}], position: 6500, duration: 0 },
            { id: "eid277", tween: [ "style", "${_hojas2}", "opacity", '1', { fromValue: '0'}], position: 9500, duration: 1000 },
            { id: "eid125", tween: [ "style", "${_Text2}", "opacity", '1', { fromValue: '0'}], position: 5500, duration: 1000 },
            { id: "eid85", tween: [ "color", "${_Text4}", "color", 'rgba(0,140,133,1.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(0,0,0,1.00)'}], position: 2500, duration: 1000 },
            { id: "eid74", tween: [ "style", "${_Text3}", "top", '53px', { fromValue: '-72px'}], position: 1500, duration: 1000 },
            { id: "eid159", tween: [ "style", "${_Text3}", "top", '53px', { fromValue: '53px'}], position: 6500, duration: 0 },
            { id: "eid283", tween: [ "style", "${_hojas1}", "left", '787px', { fromValue: '791px'}], position: 9500, duration: 1000 },
            { id: "eid70", tween: [ "style", "${_Text3}", "left", '326px', { fromValue: '326px'}], position: 2500, duration: 0 },
            { id: "eid149", tween: [ "style", "${_Text3}", "left", '326px', { fromValue: '326px'}], position: 6500, duration: 0 },
            { id: "eid37", tween: [ "style", "${_Text}", "top", '0px', { fromValue: '215px'}], position: 0, duration: 1000 },
            { id: "eid163", tween: [ "style", "${_Text}", "top", '0px', { fromValue: '0px'}], position: 6500, duration: 0 },
            { id: "eid257", tween: [ "style", "${_Text7}", "opacity", '1', { fromValue: '0'}], position: 9500, duration: 1000 },
            { id: "eid95", tween: [ "style", "${_Text6}", "left", '434px', { fromValue: '434px'}], position: 4500, duration: 0 },
            { id: "eid147", tween: [ "style", "${_Text6}", "left", '434px', { fromValue: '434px'}], position: 6500, duration: 0 },
            { id: "eid66", tween: [ "transform", "${_bienestar12}", "scaleX", '0.8', { fromValue: '0.5'}], position: 1000, duration: 1000 },
            { id: "eid47", tween: [ "style", "${_TextCopy}", "top", '0px', { fromValue: '197px'}], position: 0, duration: 1000 },
            { id: "eid162", tween: [ "style", "${_TextCopy}", "top", '0px', { fromValue: '0px'}], position: 6500, duration: 0 },
            { id: "eid98", tween: [ "style", "${_Text6}", "top", '170px', { fromValue: '285px'}], position: 3500, duration: 1000 },
            { id: "eid157", tween: [ "style", "${_Text6}", "top", '170px', { fromValue: '170px'}], position: 6500, duration: 0 },
            { id: "eid241", tween: [ "style", "${_TextCopy2}", "left", '770px', { fromValue: '770px'}], position: 9500, duration: 0 },
            { id: "eid88", tween: [ "style", "${_Text5}", "top", '134px', { fromValue: '134px'}], position: 4000, duration: 0 },
            { id: "eid161", tween: [ "style", "${_Text5}", "top", '134px', { fromValue: '134px'}], position: 6500, duration: 0 },
            { id: "eid239", tween: [ "style", "${_Rectangle2Copy3}", "top", '99px', { fromValue: '293px'}], position: 7500, duration: 1000 },
            { id: "eid216", tween: [ "style", "${_Rectangle2Copy2}", "left", '764px', { fromValue: '764px'}], position: 7500, duration: 0 },
            { id: "eid111", tween: [ "style", "${_bienestar2}", "opacity", '1', { fromValue: '0'}], position: 4000, duration: 1500 },
            { id: "eid250", tween: [ "style", "${_Text2Copy}", "top", '28px', { fromValue: '28px'}], position: 9500, duration: 0 },
            { id: "eid81", tween: [ "style", "${_Text4}", "left", '463px', { fromValue: '800px'}], position: 2500, duration: 1000 },
            { id: "eid148", tween: [ "style", "${_Text4}", "left", '463px', { fromValue: '463px'}], position: 6500, duration: 0 },
            { id: "eid82", tween: [ "style", "${_Text4}", "top", '97px', { fromValue: '95px'}], position: 2500, duration: 1000 },
            { id: "eid158", tween: [ "style", "${_Text4}", "top", '97px', { fromValue: '97px'}], position: 6500, duration: 0 },
            { id: "eid76", tween: [ "subproperty", "${_Text3}", "filter.blur", '0px', { fromValue: '10px'}], position: 1500, duration: 1000 },
            { id: "eid142", tween: [ "style", "${_Rectangle2Copy}", "top", '60px', { fromValue: '397px'}], position: 3500, duration: 3000 },
            { id: "eid91", tween: [ "subproperty", "${_Text5}", "filter.blur", '0px', { fromValue: '10px'}], position: 3000, duration: 1000 },
            { id: "eid69", tween: [ "style", "${_bienestar12}", "top", '34px', { fromValue: '51px'}], position: 1000, duration: 1000 },
            { id: "eid160", tween: [ "style", "${_bienestar12}", "top", '34px', { fromValue: '34px'}], position: 6500, duration: 0 },
            { id: "eid40", tween: [ "subproperty", "${_Text}", "filter.blur", '0px', { fromValue: '10px'}], position: 0, duration: 1000 },
            { id: "eid126", tween: [ "style", "${_Text2}", "top", '244px', { fromValue: '440px'}], position: 5500, duration: 1000 },
            { id: "eid72", tween: [ "style", "${_Text3}", "opacity", '1', { fromValue: '1'}], position: 2500, duration: 0 },
            { id: "eid84", tween: [ "style", "${_Text4}", "opacity", '1', { fromValue: '0'}], position: 2500, duration: 1000 },
            { id: "eid218", tween: [ "style", "${_Rectangle2Copy2}", "top", '-108px', { fromValue: '-404px'}], position: 6500, duration: 1000 },
            { id: "eid281", tween: [ "style", "${_hojas2}", "left", '1086px', { fromValue: '1090px'}], position: 9500, duration: 1000 },
            { id: "eid93", tween: [ "style", "${_Text5}", "opacity", '1', { fromValue: '0.20547945205479'}], position: 3000, duration: 1000 },
            { id: "eid56", tween: [ "style", "${_bienestar12}", "left", '25px', { fromValue: '-300px'}], position: 1000, duration: 1000 },
            { id: "eid150", tween: [ "style", "${_bienestar12}", "left", '25px', { fromValue: '25px'}], position: 6500, duration: 0 },
            { id: "eid266", tween: [ "style", "${_Text7}", "top", '338px', { fromValue: '338px'}], position: 10500, duration: 0 }         ]
      }
   }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-4529078");
