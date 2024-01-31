import { Component } from 'react';
import './App.css';
import FirstComponent from './components/learning-examples/FirstComponent'
import {FifthComponent} from './components/learning-examples/FirstComponent'
//import TenthComponent from './components/learning-examples/FirstComponent'

import SecondComponent from './components/learning-examples/SecondComponent'
import ThirdComponent from './components/learning-examples/ThirdComponent'
import FourthComponent from './components/learning-examples/FourthComponent'

import TodoApp from './components/todo/TodoApp'

function App() {
  return (
    <div className="App">
      My Todo Application Updated
      <FirstComponent/>
      <SecondComponent/>
      <ThirdComponent/>
      <FourthComponent/>
      <FifthComponent/>
      //<TenthComponent/>
      <TodoApp />
    </div>
  )
}

/* function FirstComponent(){
  return(
    <div className="FirstComponent">FirstComponent</div>
  )
}
function SecondComponent(){
  return(
    <div className="SecondComponent">SecondComponent</div>
  )
}

class ThirdComponent extends Component{
  render(){
    return(
      <div className="ThirdComponent">ThirdComponent</div>
    )
  }

}

class FourthComponent extends Component{
  render(){
    return(
      <div className="FourthComponent">FourthComponent</div>
    )
  }

} */
//{property1: 'value1', property2: 'value2'}
// function PlayingWithProps(properties) {
  
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)
  
//   return (
//     <div>Props</div>
//   )
// }

// function PlayingWithProps( {property1, property2} ) {
//   console.log(property1)
//   console.log(property2)
  
//   return (
//     <div>Props</div>
//   )
// }


export default App;
