import { ElMessage } from "element-plus";

const showMessages = (
  showClose: boolean,
  type: "success" | "error" | "warning" | "info",
  message: string
) => {
  ElMessage({
    showClose: showClose,
    message: message,
    center: true,
    type: type,
  });
};
const showMessagesForSuccess = (message: string) => {
  showMessages(true, "success", message);
};

const showMessagesForError = (message: string) => {
  showMessages(true, "error", message);
};

const showMessagesForWarning = (message: string) => {
  showMessages(true, "warning", message);
};

const showMessagesForInfo = (message: string) => {
  showMessages(true, "info", message);
};

export {
  showMessagesForSuccess,
  showMessagesForError,
  showMessagesForWarning,
  showMessagesForInfo,
};
