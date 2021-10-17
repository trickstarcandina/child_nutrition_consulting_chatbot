import React from 'react';
import { connect } from 'react-redux';

import { newMessageAdded } from '../../store/actions';
import ChatTitle from '../chat-title/Chat-Title';
import MessageList from '../message/Message-List';
import ChatForm from '../chat-form/Chat-Form';
import { messages } from '../../data/messages';

import './Chat-Shell.css';

const ChatShell = (onMessageSubmitted) => {
    return (
        <div id="chat-container">
            <ChatTitle />
            <MessageList messages={messages} />
            <ChatForm onMessageSubmitted={onMessageSubmitted} />
        </div>
    );
}
  
const mapDispatchToProps = dispatch => ({
    onMessageSubmitted: messageText => { dispatch(newMessageAdded(messageText)); }
});

export default connect(
    mapDispatchToProps
)(ChatShell);