// const { json } = require("react-router-dom");

const url = "http://localhost:8080/api/products/purchaseList";
const urlCurrent = "http://localhost:8080/user/current";

function sessionCurrent(data) {
  axios
    .get(urlCurrent, { withCredentials: true })
    .then((response) => {
      console.log("데이터 : ", response.data);
      if (response.status == 200) {
        const userId = response.data.userId;
        const authority = response.data.authority[0].authority;
        let cartItems = JSON.parse(localStorage.getItem(userId));
        if (cartItems) {
          displayCart(cartItems);
          const data = cartItems.map((game) => {
            // purchase 객체를 만들어서 리턴
            return {
              game: game,
              user: { userId: userId, authority: { authorityName: authority } },
            };
          });
          document
            .querySelector(".purchaseBtn")
            .addEventListener("click", () => {
              if (confirm("구매하시겠습니까?")) {
                axios
                  .post(url, data, { withCredentials: true })
                  .then((response) => {
                    console.log("데이터 : ", response.data);
                    localStorage.removeItem(userId);
                    window.location.reload();
                  })
                  .catch((error) => {
                    console.log("에러 발생 : ", error);
                  });
              }
            });
        }
      }
    })
    .catch((error) => {
      console.log("에러 발생 : ", error);
      alert("로그인해주세요.");
    });
}

function displayCart(games) {
  const tbody = document.querySelector(".cart-body");
  let totalPrice = 0;
  games.forEach((data, index) => {
    // 태그 요소 생성
    const tr = document.createElement("tr");
    const deletetd = document.createElement("td");
    const imgtd = document.createElement("td");
    const title = document.createElement("td");
    const genre = document.createElement("td");
    const price = document.createElement("td");
    const deleteBtn = document.createElement("td");
    const img = document.createElement("img");

    // 클래스이름 생성
    imgtd.classList.add("imgtd");
    img.classList.add("image");
    deleteBtn.classList.add("deleteBtn");
    // 태그속성 추가
    img.src = data.image;
    title.textContent = data.title;
    genre.textContent = data.genre;
    price.textContent = data.price + "원";
    deleteBtn.textContent = "삭제";
    // appendChild 부모자식 위치 설정
    imgtd.appendChild(img);
    deletetd.appendChild(deleteBtn);
    tr.appendChild(imgtd);
    tr.appendChild(title);
    tr.appendChild(genre);
    tr.appendChild(price);
    tr.appendChild(deletetd);
    tbody.appendChild(tr);

    totalPrice = totalPrice + data.price;
  });
  document.querySelector(".totalPrice").textContent = "총 " + totalPrice + "원";

  axios.get(urlCurrent, { withCredentials: true }).then((response) => {
    console.log("데이터 :", response.data);
    if (response.status == 200) {
      const deleteBtns = document.querySelectorAll(".deleteBtn");
      console.log(deleteBtns);
      deleteBtns.forEach((deleteBtn, index) => {
        deleteBtn.addEventListener("click", () => {
          if (confirm("삭제하시겠습니까?")) {
            const deleteData = games.toSpliced(index, 1);
            console.log("데이터 :", deleteData);
            const deleteArr = JSON.stringify(deleteData);
            console.log("데이터 :", deleteArr);
            localStorage.setItem(response.data.userId, deleteArr);
            window.location.reload();
          }
        });
      });
    }
  });
}
//     if (confirm("")) {
//     let cartList = JSON.stringify(localStorage.getItem(response.userId));
//     let deleteIndex = JSON.stringify(localStorage.getItem(response.));
//     localStorage;
//     window.location.reload();
//     console.log("데이터 :", response.index);
//   })
//   .catch((error) => {
//     console.log("에러 발생 :", error);
//   });
// }

// 페이지 로딩시에 즉시 세션여부 확인
sessionCurrent();
