import React from 'react';

import './Message-List.css';

function MessageList() {
    return (
        <div id="chat-message-list">
            <div className="message-row you-message">
                <div className="message-content">
                    <div className="message-text">Ok bro</div>
                    <div className="message-time">Apr 16</div>
                </div>
            </div>
            <div className="message-row other-message">
                <div className="message-content">
                    <img src={require("../../images/profiles/vit.png")} alt="Vịt nè" width="50" height="50"/>
                    <div className="message-text">
                    Có thể nói IT là vua của các nghề
                    Ngành IT Việt Nam hiện nay ở đầu của sự phát triển. Có thể nói IT là vua của các nghề. Vừa có tiền, có quyền. Vừa kiếm được nhiều $ lại được xã hội trọng vọng.
                    Thằng em mình học bách khoa cơ khí, bỏ ngang sang IT, sinh năm 96. Tự mày mò học code rồi đi làm remote cho công ty Mỹ 2 năm nay. Mỗi tối online 3-4 giờ là xong việc. Lương tháng 3k6. Nhưng thu nhập chính vẫn là từ nhận các project bên ngoài làm thêm. Tuần làm 2,3 cái nhẹ nhàng 9,10k tiền tươi thóc thật không phải đóng thuế. Làm gần được 3 năm mà nhà xe nó đã mua đủ cả. Nghĩ mà thèm.
                    Gái gú thì cứ nghe nó bảo làm CNTT thì chảy nước. Có bé kia dân du học sinh Úc, về được cô chị giới thiệu làm ngân hàng VCB. Thế nào thằng ấy đi mở thẻ tín dụng gặp phải thế là hốt được cả chị lẫn em. 3 đứa nó sống chung một căn hộ cao cấp. Nhà con bé kia biết chuyện ban đầu phản đối sau biết thằng đấy học IT thì đổi thái độ, cách ba bữa hỏi thăm, năm bữa tặng quà giục cưới kẻo lỡ kèo. Đáng lẽ tháng này là đám cưới tụi nó nhưng dính covid nên dời lại cuối năm rồi.
                    </div>
                    <div className="message-time">Apr 16</div>
                </div>
            </div>
            <div className="message-row you-message">
                <div className="message-content">
                    <div className="message-text">
                        Bạn có lý do gì thuyết phục tôi không ?
                    </div>
                    <div className="message-time">Apr 15</div>
                </div>
            </div>
            <div className="message-row other-message">
                <div className="message-content">
                    <img src={require("../../images/profiles/vit.png")} alt="Vịt nè" width="50" height="50"/>
                    <div className="message-text">
                        Bạn có muốn học IT ko ?
                    </div>
                    <div className="message-time">Apr 16</div>
                </div>
            </div>
            <div className="message-row you-message">
                <div className="message-content">
                    <div className="message-text">
                        Ohh
                    </div>
                    <div className="message-time">Apr 15</div>
                </div>
            </div>
            <div className="message-row other-message">
                <div className="message-content">
                    <img src={require("../../images/profiles/vit.png")} alt="Vịt nè" width="50" height="50"/>
                    <div className="message-text">
                        Tôi đang học IT.
                    </div>
                    <div className="message-time">Apr 14</div>
                </div>
            </div>
            <div className="message-row you-message">
                <div className="message-content">
                    <div className="message-text">
                        Có, tôi khỏe. Bạn đang học những gì vậy.
                    </div>
                    <div className="message-time">Apr 13</div>
                </div>
            </div>
            <div className="message-row other-message">
                <div className="message-content">
                    <img src={require("../../images/profiles/vit.png")} alt="Vịt nè" width="50" height="50"/>
                    <div className="message-text">
                        Chào, bạn khỏe chứ ?
                    </div>
                    <div className="message-time">Apr 13</div>
                </div>
            </div>
            <div className="message-row you-message">
                <div className="message-content">
                    <div className="message-text">
                        Chào bạn
                    </div>
                    <div className="message-time">Apr 13</div>
                </div>
            </div>
        </div>
    );
}

export default MessageList;