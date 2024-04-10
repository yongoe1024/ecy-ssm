Vue.component('e-message', {
    template: `
   <div>
    <div class="titleBar" style="margin-top: 10px;">
      <h1><slot></slot></h1>
    </div>
  <div style="margin-top: 10px;">
      <el-card class="box-card">
        <div>
        <el-row :gutter="20">
            <el-col :span="20">
              <el-input style="width: 100%;" type="textarea" :rows="2" placeholder="请输入内容" v-model="content" />
            </el-col>
            <el-col :span="2">
              <el-button type="primary" @click="addMessage">发布</el-button>
            </el-col>
          </el-row>
          <el-divider />
        </div>
        <!-- 用户留言 -->
        <div v-for="i in messageList" :key="i.id">
          <el-row :gutter="20">
            <el-col :span="2">
            <div style="width: 100%;height: 0;padding-bottom: 100%;position: relative;">
             <img :src="i.avatar" style="width: 100%;height: 100%;position: absolute;border-radius: 50%;" />
            </div>
            </el-col>
            <el-col :span="22">
              <div style="font-size: 16px; font-weight: 600;">
                {{ i.createBy }}
              </div>
              <div style="margin-top: 10px;">
                {{ i.content }}
              </div>
              <div style="font-size: 14px; margin-top: 10px; color: #696a6b;">
                <span>
                  {{ i.createTime }}
                </span>
                <a class="reply" style="margin-left: 50px; border: none;" @click="toReplayShow(i)">回复</a>
              </div>
              <!-- 留言回复 -->
              <div style="margin-top: 15px;" v-for="j in i.children" :key="j.id">
                <el-row :gutter="20">
                  <el-col :span="2">
                       <div style="width: 100%;height: 0;padding-bottom: 100%;position: relative;">
                        <img :src="i.avatar" style="width: 100%;height: 100%;position: absolute;border-radius: 50%;" />
                        </div>
                  </el-col>
                  <el-col :span="22">
                    <div style="font-size: 16px; font-weight: 600;">
                      {{ j.createBy }}
                    </div>
                    <div style="margin-top: 10px;">
                      {{ j.content }}
                    </div>
                    <div style="font-size: 14px; margin-top: 10px; color: #696a6b;">
                      <span>
                        {{ j.createTime }}
                      </span>
                    </div>
                  </el-col>
                </el-row>
              </div>
            </el-col>
          </el-row>
          <el-divider />
        </div>
        <el-pagination background style="margin-top: 10px; display:flex;justify-content:center;"
          @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-size="queryParam.size"
          layout="total, sizes, prev, pager, next, jumper" :total="total"></el-pagination>
      </el-card>
    </div>

  <el-drawer
  title="回复"
  :visible.sync="drawer"
  direction="btt"
  :before-close="handleClose">
   <div style="margin-top: 15px;" >
                <el-row :gutter="10">
                  <el-col :offset="1" :span="20">
                    <el-input type="textarea" :rows="2" v-model="reContent.content" placeholder="请输入内容" />
                  </el-col>
                  <el-col :span="2">
                    <el-button type="primary" style="width: 100%; height: 53px;" size="medium" plain
                      @click="toReplay">发布</el-button>
                  </el-col>
                </el-row>
              </div>
</el-drawer>
   </div>

  `,
    data: function () {
        return {
            drawer: false,
            total: 0,
            queryParam: {
                current: 1,
                size: 10,
            },
            content: '',
            reContent: {
                content: '',
                parentId: null,
            },
            messageList: [],
        }
    },
    mounted() {
        this.getList()
    },
    methods: {
        // 改变页码
        handleSizeChange(val) {
            this.queryParam.size = val
            this.getList()
        },
        // 点击页数
        handleCurrentChange(val) {
            this.queryParam.current = val
            this.getList()
        },
        toReplay() {
            post(`/project/message/add`, this.reContent).then(data => {
                this.reContent = {
                    content: '',
                    parentId: null,
                }
                this.drawer = false
                this.getList()
            })
        },
        toReplayShow(i) {
            this.drawer = true
            this.reContent = {
                content: '',
                parentId: i.id,
            }
        },
        addMessage() {
            post(`/project/message/add`, {
                content: this.content,
                parentId: 0,
            }).then(data => {
                this.drawer = false
                this.content = ''
                this.getList()
            })
        },
        getList() {
            post(`/project/message/public/page`, this.queryParam).then(data => {
                this.messageList = data.list
                this.total = data.total - 0
            })
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    this.reContent = {
                        content: '',
                        parentId: null,
                    }
                    done()
                })
                .catch(_ => {
                })
        }
    },
})

Vue.component('e-upload', {
    template: `  <div>
    <el-upload :show-file-list="false"
               :before-upload="beforeUpload"
               :on-success="onSuccess"
               :on-error="onError"
               :headers="headers"
               :disabled="uploadButtonDisabled"
               :action="url">
      <el-button :icon="uploadButtonIcon"
                 :size="size"
                 type="info"
                 plain>
        <slot v-if="!uploadButtonDisabled"></slot>
        <span v-else> {{uploadButtonText}}</span>
      </el-button>
    </el-upload>
  </div>`,
    props: {
        url: {
            type: String,
            default: () => '/upload/single'
        },
        size: {
            type: String,
            default: () => '' //medium/small/mini
        },
    },
    data() {
        return {
            uploadButtonText: '正在导入',
            uploadButtonIcon: 'el-icon-upload2',
            uploadButtonDisabled: false,
            headers: {
                Authorization: window.localStorage.getItem("token")
            },
        }
    },
    methods: {
        beforeUpload() {
            this.uploadButtonIcon = 'el-icon-loading'
            this.uploadButtonDisabled = true
        },
        onSuccess(data) {
            this.$message({message: data.message, type: data.code === 200 ? 'success' : 'error'})
            this.uploadButtonIcon = 'el-icon-upload2'
            this.uploadButtonDisabled = false
            this.$emit('success', data.data)
        },
        onError() {
            this.$message({message: '导入失败', type: 'error'})
            this.uploadButtonDisabled = false
            this.uploadButtonIcon = 'el-icon-upload2'
        },
    },

})