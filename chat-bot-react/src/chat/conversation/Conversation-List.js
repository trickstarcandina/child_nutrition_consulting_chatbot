import React from 'react';

import './Conversation-List.css';

function ConversationList() {
    return (
        <div id="conversation-list">
            <div className="conversation">
                <img src={require("../../images/profiles/bennet.png")} alt="Bennet" />
                <div className="title-text">Bennet</div>
                <div className="created-date">2:49 PM</div>
                <div className="conversation-message">
                    Bouken da bouken
                </div>
            </div>
            <div className="conversation active">
                <img src={require("../../images/profiles/vit.png")} alt="Daryl Duckmanton" />
                <div className="title-text">Vịt nè</div>
                <div className="created-date">Apr 16</div>
                <div className="conversation-message">
                    Ok bro
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/truongdz.jpg")} alt="Huy Truong" />
                <div className="title-text">Huy Truong</div>
                <div className="created-date">2 days ago</div>
                <div className="conversation-message">
                    chạy file này nhé
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/tuanh.jpg")} alt="Tú Anh" />
                <div className="title-text">Klee</div>
                <div className="created-date">7 days ago</div>
                <div className="conversation-message">
                    Ok m nhé.
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/zhongli.jpg")} alt="Zhongli" />
                <div className="title-text">Zhongli</div>
                <div className="created-date">1 week ago</div>
                <div className="conversation-message">
                    Tendo Banso
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/klee.png")} alt="Klee" />
                <div className="title-text">Klee</div>
                <div className="created-date">1 year ago</div>
                <div className="conversation-message">
                    Thank you.
                </div>
            </div>
        </div>
    );
}

export default ConversationList;