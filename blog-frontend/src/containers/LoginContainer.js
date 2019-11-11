
import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import LoginModal from '../components/Login/LoginModal';

class LoginContainer extends Component {

    
    constructor(props) {
        super(props);
    
        this.state = {
          showModal: false
        };
      }
    
      componentDidUpdate(prevProps, prevState) {
        if (this.props !== prevProps) {
          this.setState({ showModal: this.props.showModal });
        }
      }
    
    //   handleLogin = async (username, password, rememberMe = false) => {
    //     const { AuthActions } = this.props;
    //     try {
    //       await AuthActions.login(username, password);      
    //     } catch (e) {
    //       console.log("error log :" + e);
    //     }
    //   }; 
    
      handleClose = () => {
        this.setState(prevState => ({
          showModal: !prevState.showModal
        }));
      };
    
      render() {
        const { location, isAuthenticated } = this.props;
        const { showModal } = this.state;
        // const { from } = location.state || { from: { pathname: '/', search: location.search } };
    
        // if (isAuthenticated) {
        //    return <Redirect to={from} />;
        // }
        return (  
          <LoginModal showModal={!showModal} handleLogin={this.handleLogin} handleClose={this.handleClose} loginError={this.props.loginError} />
        );
      }

}

export default LoginContainer;