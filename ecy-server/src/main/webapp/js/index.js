const baseUrl = ''
/**
 * a标签下载
 * @param url 路径
 * @param params 参数
 */
function download (url, params) {
  var a = document.createElement("a")
  var str = ''
  if (params) {
    str = Object.keys(params).map(key => {
      if (typeof (params[key]) !== "undefined" && params[key] !== null) {
        return `${key}=${params[key]}`
      }
    }).join('&')
  }
  a.href = `${baseUrl}${url}?Authorization=${window.localStorage.getItem('token')}&${str}`
  a.style.display = "none"
  a.target = '_blank'
  document.body.appendChild(a)
  a.click()
  a.remove()
}


const ax = axios.create({
  baseURL: baseUrl,
  withCredentials: true,  //是否允许跨域, 解决请求不包含cookie  ：session
  timeout: 5000
})

//请求拦截器
ax.interceptors.request.use(config => {
  if (window.localStorage.getItem('token')) {
    config.headers['Authorization'] = window.localStorage.getItem('token')
  }
  return config
}), error => {
  console.log(error)
  Promise.reject(error)
}

//响应拦截器
ax.interceptors.response.use(
  response => {
    if (response.status == 200) {
      // 未登录
      if (response.data.code == 401) {
        ELEMENT.Message.error({ message: response.data.message })
        window.localStorage.clear()
        window.sessionStorage.clear()
        window.location.href = '/page/login.html'
      }
      else if (response.data.code != 200) {
        ELEMENT.Message.error({ message: response.data.message })
        return Promise.reject(response)
      }
      //有信息就提示
      else {
        if (response.data.message) {
          ELEMENT.Message.success({ message: response.data.message })
        }
      }
      return response.data.data
    }
  },
  error => {
    console.log(error)
    if (!error.response) {
      ELEMENT.Message.error({ message: error.message })
    }
    ELEMENT.Message.error({ message: error.response.status + ' ' + error.response.statusText })
  })

var get = ax.get
var post = ax.post
var put = ax.put
var del = ax.delete


//根据传递过来的参数name获取对应的值
function getParameter (name) {
  var urlParams = new URLSearchParams(window.location.search)
  if (urlParams.has(name)) {
    return urlParams.get(name)
  }
  return ''
}
// 去掉时间，变为yyyy-MM-dd格式
Vue.prototype.formatDate = function (str) {
  let index = str.indexOf(' ') // 查找第一个空格的位置
  let result = index === -1 ? str : str.substring(0, index)
  return result
}

function refreshIframeHeight () {
  // 获取所有iframe
  var iframes = document.querySelectorAll('iframe')
  iframes.forEach(function (iframe) {
    iframe.style.height = iframe.contentWindow.document.body.scrollHeight + 'px'
  })
}
function resizeIframe (iframe) {
  iframe.style.height = iframe.contentWindow.document.body.scrollHeight + 'px'
}
// 每隔一段时间调用一次
setInterval(refreshIframeHeight, 2000) 