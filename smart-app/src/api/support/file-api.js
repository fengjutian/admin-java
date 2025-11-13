
import { uploadRequest } from '@/lib/smart-request';

export const fileApi = {
  upload: (file, folder) => {
    return uploadRequest(file, folder);
  },
};

