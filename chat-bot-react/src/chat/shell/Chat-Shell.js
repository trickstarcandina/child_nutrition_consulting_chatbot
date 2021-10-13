import React from 'react';
import ChatTitle from '../chat-title/Chat-Title';
import MessageList from '../message/Message-List';
import ChatForm from '../chat-form/Chat-Form';
import { messages } from '../../data/messages';

import './Chat-Shell.css';

const ChatShell = () => {
    return (
        <div id="chat-container">
            <ChatTitle />
            <MessageList messages={messages} />
            <ChatForm />
        </div>
    );
}

export default ChatShell;