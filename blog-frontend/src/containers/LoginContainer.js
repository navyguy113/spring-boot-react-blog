
import React, { Component } from 'react';
import LoginModal from '../components/Login/LoginModal';

class LoginContainer extends Component {
    // constructor(props) {
    //     super(props);
    
    //     this.state = {
    //         showModal: false
    //     };
    // }
    
    // handleClose = () => {
    //     this.setState(prevState => ({
    //         showModal: !prevState.showModal
    //     }));
    // };

    
    render() {
        return ( <LoginModal/>);
        // const { showModal } = this.state;
        // const { showModal } = this.state;
        // return (  
        //     <LoginModal showModal={!showModal} handleClose={this.handleClose} />
        // );
    }

}

export default LoginContainer;