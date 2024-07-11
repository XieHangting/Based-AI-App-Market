import { defineStore } from "pinia";
import { ref } from "vue";
import { getLoginUserUsingGet } from "@/api/userController";
import ACCESS_ENUM from "@/access/accessEnum";

/***
 * 登录用户信息全局状态
 */
export const useLoginUserStore = defineStore("counter", () => {
  const loginUser = ref<API.LoginUserVO>({
    userName: "未登录",
  });

  function setLoginUser(newLoginUser: API.LoginUserVO) {
    loginUser.value = newLoginUser;
  }

  async function fetchLoginUser() {
    const res = await getLoginUserUsingGet();
    if (res.data.code === 0 && res.data.data) {
      loginUser.value = res.data.data;
    } else {
      // loginUser.value = { userRole: ACCESS_ENUM.NOT_LOGIN };
      setTimeout(() => {
        // 重新获取用户信息失败，则重置登录状态
        loginUser.value = {
          id: 1,
          userName: "已登录",
          userRole: ACCESS_ENUM.ADMIN,
        };
      }, 5000);
    }
  }

  return { loginUser, setLoginUser, fetchLoginUser };
});
