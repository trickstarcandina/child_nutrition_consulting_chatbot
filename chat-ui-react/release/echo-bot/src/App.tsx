import {
  Box,
  // Button,
  CssBaseline,
  Divider,
  // Link,
  ThemeProvider,
  Typography,
  createTheme,
} from '@mui/material';
import {
  // ActionRequest,
  // AudioActionResponse,
  ChatController,
  // FileActionResponse,
  MuiChat,
} from 'chat-ui-react';
import React from 'react';

const muiTheme = createTheme({
  palette: {
    primary: {
      main: '#007aff',
    },
  },
});

export function App(): React.ReactElement {
  const [chatCtl] = React.useState(
    new ChatController({
      showDateTime: true,
    }),
  );

  React.useMemo(() => {
    echo(chatCtl);
  }, [chatCtl]);

  return (
    <ThemeProvider theme={muiTheme}>
      <CssBaseline />
      <Box sx={{ height: '100%', backgroundColor: 'gray' }}>
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            height: '100%',
            maxWidth: '640px',
            marginLeft: 'auto',
            marginRight: 'auto',
            bgcolor: 'background.default',
          }}
        >
          <Typography sx={{ p: 1 }}>
            Chào mừng đến với hệ thống tư vấn dinh dưỡng cho trẻ em
          </Typography>
          <Divider />
          <Box sx={{ flex: '1 1 0%', minHeight: 0 }}>
            <MuiChat chatController={chatCtl} />
          </Box>
        </Box>
      </Box>
    </ThemeProvider>
  );
}

async function echo(chatCtl: ChatController): Promise<void> {
  // chọn kịch bản
  await chatCtl.addMessage({
    type: 'text',
    content: `Bạn muốn tư vấn về?`,
    self: false,
    avatar: '-',
  });
  const mulSel = await chatCtl.setActionRequest({
    type: 'select',
    options: [
      {
        value: 'KB1',
        text: '1 : Hỏi về chế độ ăn hàng ngày',
      },
      {
        value: 'KB2',
        text: '2 : Hỏi về chế độ dinh dưỡng cho các hiện tượng',
      },
      {
        value: 'KB3',
        text: '3 : Hỏi về vai trò và nhu cầu của chất dinh dưỡng',
      },
    ],
  });

  let mauCauHoi = '';
  let messageHuongDan = 'Hãy nhập vào dấu ... trong mẫu câu bên dưới.';
  switch (mulSel.value) {
    case '1 : Hỏi về chế độ ăn hàng ngày':
      mauCauHoi +=
        'Chào bác sĩ, tôi muốn hỏi chế độ ăn cho cháu có chiều cao … cm ; cân nặng … kg ; giới tính … ; … tháng tuổi.';
      break;
    case '2 : Hỏi về chế độ dinh dưỡng cho các hiện tượng':
      mauCauHoi +=
        'Chào bác sĩ, cháu nhà tôi có hiện tượng … thì chế độ dinh dưỡng như thế nào để khắc phục ạ ?';
      messageHuongDan +=
        '\nBạn có thể nhập nhiều hiện tượng vào dấu … , mỗi hiện tượng cách nhau 1 dấu “;”';
      break;
    case '3 : Hỏi về vai trò và nhu cầu của chất dinh dưỡng':
      mauCauHoi +=
        'Chào bác sĩ, tôi cần biết thông tin về chất … cho trẻ … tháng tuổi';
      break;
    default:
      break;
  }

  await chatCtl.addMessage({
    type: 'text',
    content: messageHuongDan,
    self: false,
    avatar: '-',
  });

  const text = await chatCtl.setActionRequest({
    type: 'text',
    defaultValue: mauCauHoi,
    placeholder: 'Please enter something',
  });

  // const parseJson = await response.json().then((data) => data.message);

  const urlAPI = `http://34.122.94.78:8999/api/sendMessage?message=${text.value}`;
  const response = await fetch(urlAPI, {
    method: 'POST',
  });

  const parseJson = await response.text();

  await chatCtl.addMessage({
    type: 'text',
    content: `${parseJson}`,
    self: false,
    avatar: '-',
  });

  // await chatCtl.addMessage({
  //   type: 'text',
  //   content: `You have entered:\n${text.value}`,
  //   self: false,
  //   avatar: '-',
  // });

  /* gender
  await chatCtl.addMessage({
    type: 'text',
    content: `What is your gender?`,
    self: false,
    avatar: '-',
  });
  const sel = await chatCtl.setActionRequest({
    type: 'select',
    options: [
      {
        value: 'man',
        text: 'Man',
      },
      {
        value: 'woman',
        text: 'Woman',
      },
      {
        value: 'other',
        text: 'Other',
      },
    ],
  });
  await chatCtl.addMessage({
    type: 'text',
    content: `You have selected ${sel.value}.`,
    self: false,
    avatar: '-',
  });
  */

  /* send picture
  await chatCtl.addMessage({
    type: 'text',
    content: `What is your favorite picture?`,
    self: false,
    avatar: '-',
  });
  const file = (await chatCtl.setActionRequest({
    type: 'file',
    accept: 'image/*',
    multiple: true,
  })) as FileActionResponse;
  await chatCtl.addMessage({
    type: 'jsx',
    content: (
      <div>
        {file.files.map((f) => (
          <img
            key={file.files.indexOf(f)}
            src={window.URL.createObjectURL(f)}
            alt="File"
            style={{ width: '100%', height: 'auto' }}
          />
        ))}
      </div>
    ),
    self: false,
    avatar: '-',
  });
  */

  /* send voice 
  await chatCtl.addMessage({
    type: 'text',
    content: `Please enter your voice.`,
    self: false,
    avatar: '-',
  });
  const audio = (await chatCtl
    .setActionRequest({
      type: 'audio',
    })
    .catch(() => ({
      type: 'audio',
      value: 'Voice input failed.',
      avatar: '-',
    }))) as AudioActionResponse;
  await (audio.audio
    ? chatCtl.addMessage({
        type: 'jsx',
        content: (
          <a href={window.URL.createObjectURL(audio.audio)}>Audio downlaod</a>
        ),
        self: false,
        avatar: '-',
      })
    : chatCtl.addMessage({
        type: 'text',
        content: audio.value,
        self: false,
        avatar: '-',
      }));

  await chatCtl.addMessage({
    type: 'text',
    content: `Please press the button.`,
    self: false,
    avatar: '-',
  });
  const good = await chatCtl.setActionRequest({
    type: 'custom',
    Component: GoodInput,
  });
  await chatCtl.addMessage({
    type: 'text',
    content: `You have pressed the ${good.value} button.`,
    self: false,
    avatar: '-',
  });
  */

  echo(chatCtl);
}
/*
function GoodInput({
  chatController,
  actionRequest,
}: {
  chatController: ChatController;
  actionRequest: ActionRequest;
}) {
  const chatCtl = chatController;

  const setResponse = React.useCallback((): void => {
    const res = { type: 'custom', value: 'Good!' };
    chatCtl.setActionResponse(actionRequest, res);
  }, [actionRequest, chatCtl]);

  return (
    <div>
      <Button
        type="button"
        onClick={setResponse}
        variant="contained"
        color="primary"
      >
        Good!
      </Button>
    </div>
  );
}
*/
