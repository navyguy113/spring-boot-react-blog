import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import LoginContainer from '../containers/LoginContainer'

class App extends Component {
  render() {
    return (
      <div className="App">
        <LoginContainer/>
        {/* <Route path="/login" component={LoginContainer} />        */}
      </div>
    );
  }
};

export default App;
