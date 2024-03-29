const { defineConfig } = require('@vue/cli-service')
const Timestamp = new Date().getTime()
module.exports = defineConfig({
  chainWebpack: config => {
    config.output.filename(`js/[name].${Timestamp}.js`)
    config.output.chunkFilename(`js/[name].${Timestamp}.js`)
  },
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: '/',
  devServer: {
    client: {
      overlay: false,
    },
    port: 8080,
    allowedHosts: [
      'all', // 允许访问的域名地址
    ],
    // 打包后就用nginx转发啦
    proxy: {
      '/': {
        target: 'http://localhost:8081',
        ws: true,
        changeOrigin: true
      },
    }
  }
})
