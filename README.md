![vuejs+spring](https://k.kakaocdn.net/dn/dk4pvq/btqtZ9OKcCM/eE9aDPVhGgYO3ezyM358Ik/img.png)

# Vue.js + Spring Framework

- 진행자: **박성진** `develop`

## JavaScript Code Style

- ECMAScript 6+ 스펙 사용
  1. var 변수는 사용 안하고, let과 const로 Block Scope 형태로 코딩.
  2. Airbnb JavaScript Style을 필수로 따름

## Vue.js

**추가 완료 리스트**

- vee-validate(Form validator)

**추가 예정 리스트**

- vuex (vue 상태관리 => store 컨테이너에 변경된 상태만 렌더링 => 클라이언트 성능 극대화)

![vuejs_lifecycle](https://codingexplained.com/wp-content/uploads/2017/04/Vue-instance-lifecycle-Page-1.png)

### 뷰 라이프사이클 적극 활용

**Create**  
Vue.JS의 라이프 사이클들 중에 가장 먼저 실행됩니다. create 단계에서 실행되는 라이프 사이클 훅(hook)들은 컴포넌트가 DOM에 추가 되기 전이기 때문에, DOM에 접근하거나 this.\$el을 사용할 수 없습니다. 컴포넌트가 DOM에 추가 되기 전에 호출 되기 때문에 서버 사이드 렌더링에서도 지원되는 훅입니다. Create 단계에서 호출되는 라이프 사이클 훅들은 beforeCreate와 created가 있습니다.

`beforeCreate`  
Vue.JS의 라이프 사이클 훅 중에서 가장 먼저 실행 되는 훅입니다. data와 이벤트($on, $once, $off, $emit), 감시자(\$watch)등이 설정 되기 전에 호출되는 라이프 사이클 훅입니다.

`created`  
data, computed, methods, watch 등과 같은 옵션 설정이 완료된 시점이기 때문에, data 등을 사용할 수 있습니다. 하지만 아직 DOM에 컴포넌트가 마운트 되지 않았기 때문에 \$el은 사용할 수 없습니다.

**Mount**  
 컴포넌트가 DOM에 추가될 때, 실행되는 라이프 사이클 훅입니다. 서버 사이드 렌더링을 지원하지 않습니다. 렌더링이 될 때 DOM을 변경하고 싶다면 이 라이프 사이클 훅을 사용할 수 있습니다. 하지만 컴포넌트 초기에 data가 세팅되어야 한다면, created 라이프 사이클 훅을 사용하는 것이 좋습니다. Mount 단계에서 호출되는 라이프 사이클 훅들은 beforeMount와 mounted가 있습니다.

`beforeMount`  
컴포넌트가 DOM에 추가 되기 직전에 실행되는 훅입니다. 서버 사이드 렌더링을 지원하지 않습니다. 컴포넌트 초기에 data가 세팅되어야 한다면 created 라이프 사이클 훅을, 렌더링 되고 DOM을 변경해야 한다면 mounted 라이프 사이클 훅을 사용하면 되기 때문에, 거의 사용하지 않는 라이프 사이클 훅입니다.

`mounted`  
컴포넌트가 DOM에 추가 된 후 호출되는 라이프 사이클 훅입니다. 서버 사이드 렌더링은 지원하지 않습니다. $el을 사용하여 DOM에 접근 할 수 있습니다. mounted 훅이 호출되었다고 모든 컴포넌트가 마운트 되었다고 보장할 수는 없습니다. 전체가 렌더링 보장된 상태에서 작업을 하기 위해서는 $nextTick을 사용해야 합니다.

**Update**  
컴포넌트에서 사용되는 속성들이 변경되는 등의.. 컴포넌트가 재 랜더링 되면 실행되는 라이프 사이클 훅입니다. 컴포넌트가 재 렌더링 될 때, 변경 된 값으로 어떠한 작업을 해야 할 때 유용하게 사용 되는 훅입니다. 서버 사이드 렌더링은 지원하지 않습니다.

`beforeUpdate`  
DOM이 재 렌더링 되기 직전에 호출되는 라이프 사이클 훅입니다. 업데이트 된 값들을 가지고 있는 상태이기 때문에, 업데이트 된 값으로 다른 값들을 업데이트 할 수 있습니다. 이 훅에서 값이 변경되더라도 다시 beforeUpdate 훅이 호출 되지 않기 때문에, 무한 루프에 빠질 걱정은 하지 않으셔도 됩니다.

`updated`  
DOM이 재 렌더링 된 후 호출되는 라이프 사이클 훅입니다. DOM이 업데이트 된 후 호출 되는 훅이기 때문에 변경 된 후의 DOM을 이용해야 하는 처리를 할 때 사용하기 유용한 훅입니다. mounted 훅과 마찬가지로 재 렌더링이 끝났다는 것이 보장된 상태에서 작업하기 위해서는 \$nextTick을 사용해야 합니다. beforeUpdate 훅과 다르게 updated 훅에서 data를 수정하게 되면 update 훅이 호출 되기 때문에 무한 루프에 빠질 수 있으니 유의해야 합니다.

**Destroy**  
컴포넌트가 제거 될 때 실행되는 라이프 사이클 훅입니다.

`beforeDestroy`  
컴포넌트가 제거 되기 직전에 호출되는 라이프 사이클 훅입니다. 이 훅에서 컴포넌트는 본래의 기능들을 가지고 있는 온전한 상태입니다. 이 훅에서 이벤트 리스너를 해제하거나 컴포넌트에서 동작으로 할당 받은 자원들은 해제해야 할 때 사용하기 적합한 훅입니다. 서버 사이드 렌더링을 지원하지 않습니다.

`destroyed`  
컴포넌트가 제거 된 후 호출되는 라이프 사이클 훅입니다. 컴포넌트의 모든 이벤트 리스너(@click, @change 등..)와 디렉티브(v-model, v-show 등..)의 바인딩이 해제 되고, 하위 컴포넌트도 모두 제거됩니다. 서버 사이드 렌더링을 지원하지 않습니다.

## 스프링 프레임워크

### 추가예정

- 스프링 시큐리티(CSRF 공격 방어 + SHA256이상 데이터 암호화)
- 스프링 타일즈 => 페이지 이동시 전체 페이지 렌더링시 성능 저하 방지
- Spring LocaleResolver(다국어 처리)

## HTTP 통신 방식 (Axios)

- 뷰에서 권고하는 HTTP 통신 라이브러리
- Promise 기반의 HTTP 통신 라이브러리이며 상대적으로 다른 HTTP 통신
- 라이브러리들에 비해 문서화가 잘되어 있고 API가 다양함.

**액시오스 설치**
프로젝트에 액시오스를 설치하는 방법은 CDN 방식과 NPM 방식 2가지가 있음.

### CDN 방식

```js
<script src="https://unpkg.com/axios/dist/axios.min.js" />
```

### NPM & yarn 방식

```bash
$ npm install axios
$ yarn add axios
```

## 액시오스 사용방법

라이브러리를 설치하고 나면 axios라는 변수에 접근할 수 있게 됩니다.  
axios 변수를 이용하여 아래와 같이 HTTP GET 요청을 날리는 코드를 작성합니다.

```html
<div id="app">
  <button v-on:click="fetchData">get data</button>
</div>
```

```js
new Vue({
  el: "#app",
  methods: {
    fetchData: function() {
      axios
        .get("https://jsonplaceholder.typicode.com/users/")
        .then(function(response) {
          console.log(response);
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
});
```

위 코드는 get data 버튼을 클릭했을 때 사용자 정보를 받아오는 코드입니다.  
실행하면 사용자 정보가 브라우저 개발자 도구의 콘솔에 출력됩니다.

## Spring Framework + Vue.js 적용 화면

![완성본](https://k.kakaocdn.net/dn/bAYu5L/btqtYtHDg30/3JY8V8uPbCpPo3dm0ZdXp0/img.png)
