import React from 'react'; 
import { Switch, Route } from 'react-router-dom';
import LoginContainer from 'containers/LoginContainer'

function App() {
  return (
    <div className="App">
      <Route path="/login" component={LoginContainer} />       
    </div>
  );
}

export default App;
