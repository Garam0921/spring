const urlLogin = "http://localhost:8080/user/login";
const urlLogout = "http://localhost:8080/user/logout";
const urlSignup = "http://localhost:8080/user/signup";

let userId = "";
let password = "";

let signupUserId = "";
let signupPassword = "";
let signupUserName = "";
let signupUserEmail = "";

document.querySelector("#userId").addEventListener("change", (e) => {
  console.log(e.target.value);
  userId = e.target.value;
});
document.querySelector("#password").addEventListener("change", (e) => {
  console.log(e.target.value);
  password = e.target.value;
});

document.querySelector(".loginBtn").addEventListener("click", () => {
  const data = {
    userId: userId,
    password: password,
  };
  axios
    .post(urlLogin, data, { withCredentials: true })
    .then((response) => {
      console.log("데이터: ", response);
      sessionCurrent();
    })
    .catch((error) => {
      console.log("에러 발생: ", error);
    });
});
document.querySelector(".logoutBtn").addEventListener("click", () => {
  if (confirm("로그아웃하시겠습니까?")) {
    axios
      .post(urlLogout, {}, { withCredentials: true })
      .then((response) => {
        console.log("데이터:", response);
        if (response.status == 200) {
          document.querySelector(".login-box").classList.remove("hidden");
          document.querySelector(".user-box").classList.add("hidden");
        }
      })
      .catch((error) => {
        console.log("에러 발생:", error);
      });
  }
});

document.querySelector(".signupBtn").addEventListener("click", () => {
  document.querySelector(".login-box").classList.add("hidden");
  document.querySelector(".signup-box").classList.remove("hidden");
});

document.querySelector("#signupUserId").addEventListener("change", (e) => {
  console.log(e.target.value);
  signupUserId = e.target.value;
});
document.querySelector("#signupPassword").addEventListener("change", (e) => {
  console.log(e.target.value);
  signupPassword = e.target.value;
});
document.querySelector("#signupUserName").addEventListener("change", (e) => {
  console.log(e.target.value);
  signupUserName = e.target.value;
});
document.querySelector("#signupUserEmail").addEventListener("change", (e) => {
  console.log(e.target.value);
  signupUserEmail = e.target.value;
});

document.querySelector(".signupEnd").addEventListener("click", () => {
  if (confirm("회원가입 하시겠습니까?")) {
    const data = {
      userId: signupUserId,
      password: signupPassword,
      userName: signupUserName,
      userEmail: signupUserEmail,
    };
    axios
      .post(urlSignup, data, { withCredentials: true })
      .then((response) => {
        console.log("데이터:", response);
        if (response.status == 201) {
          alert("회원가입 완료");
          document.querySelector(".login-box").classList.remove("hidden");
          document.querySelector(".signup-box").classList.add("hidden");
          window.location.reload();
        }
      })
      .catch((error) => {
        console.log("에러 발생:", error);
      });
  }
});

function sessionCurrent() {
  axios
    .get("http://localhost:8080/user/current", { withCredentials: true })
    .then((response) => {
      console.log("데이터:", response);
      if (response.status == 200) {
        console.log("세션 유지");
        if (response.status == 200) {
          document.querySelector(".login-box").classList.add("hidden");
          document.querySelector(".user-box").classList.remove("hidden");
          document.querySelector(".user-box p").textContent =
            response.data.userId + "님, 환영합니다.";
        }
      }
    })
    .catch((error) => {
      console.log("에러 발생:", error);
    });
}

// js 파일이 로드될 때 호출됨
sessionCurrent();
