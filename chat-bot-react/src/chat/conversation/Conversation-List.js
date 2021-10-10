import React from 'react';

import './Conversation-List.css';

function ConversationList() {
    return (
        <div id="conversation-list">
            <div className="conversation active">
                <img src={require("../../images/profiles/candina.png")} alt="Trickstar Candina" />
                <div className="title-text">Tú Anh</div>
                <div className="created-date">3:30 PM</div>
                <div className="conversation-message">
                    Thằng em mình sinh năm 96
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/corobane.jpg")} alt="Trickstar Corobane" />
                <div className="title-text">Trickstar Corobane</div>
                <div className="created-date">1 days ago</div>
                <div className="conversation-message">
                    Học cơ khí bách khoa
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/holly1.png")} alt="Trickstar Holly Angel" />
                <div className="title-text">Trickstar Holly Angel</div>
                <div className="created-date">1 week ago</div>
                <div className="conversation-message">
                    ehhe
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/holly2.png")} alt="Trickstar Holly Angel 2" />
                <div className="title-text">Huy Trường</div>
                <div className="created-date">29/07/2020</div>
                <div className="conversation-message">
                    Alo bạn
                </div>
            </div>
            {/* <div className="conversation">
                <img src={require("../../images/profiles/douglas.png")} alt="Douglas Johannasen" />
                <div className="title-text">Douglas Johannasen</div>
                <div className="created-date">6:14 PM</div>
                <div className="conversation-message">
                    No it does not
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/jacob.png")} alt="Jacob Manly" />
                <div className="title-text">Jacob Manly</div>
                <div className="created-date">3 secs ago</div>
                <div className="conversation-message">
                    Just be very careful doing that
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/stacey.jpeg")} alt="Stacey Wilson" />
                <div className="title-text">Stacey Wilson</div>
                <div className="created-date">30 mins ago</div>
                <div className="conversation-message">
                    Awesome!!! Congratulations!!!!
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/stan.jpeg")} alt="Stan George" />
                <div className="title-text">Stan George</div>
                <div className="created-date">1 week ago</div>
                <div className="conversation-message">
                    Good job
                </div>
            </div>
            <div className="conversation">
                <img src={require("../../images/profiles/sarah.jpeg")} alt="Sarah Momes" />
                <div className="title-text">Sarah Momes</div>
                <div className="created-date">1 year ago</div>
                <div className="conversation-message">
                    Thank you. I appreciate that.
                </div>
            </div> */}
        </div>
    );
}

export default ConversationList;