<template>
  <div>
    <div class="container">
      <div class="select-container">
        <el-select v-model="value" placeholder="翻译语言选择" style="margin-left: 30px; box-shadow:1px 1px 10px rgba(0, 0, 0, 0.2);">
          <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
      </div>
      <div class="select-container">
      </div>
    </div>
    <div class="container">
      <div class="app-container">
        <el-input
          v-model="question"
          size=""
          type="textarea"
          :autosize="{ minRows: 15, maxRows: 20 }"
          placeholder="请输入待翻译内容"
          style="box-shadow:1px 1px 10px rgba(0, 0, 0, 0.3);"
        />
      </div>
      <div class="app-container">
        <el-input
          v-model="answer"
          size=""
          type="textarea"
          disabled="true"
          :autosize="{ minRows: 15, maxRows: 20 }"
          placeholder="翻译结果"
          style="box-shadow:1px 1px 10px rgba(0, 0, 0, 0.3);"
        />
      </div>
    </div>
  </div>
</template>
<script>
import { translate } from '@/api/translate'
export default {
  data() {
    return {
      question: '',
      answer: '',
      options: [{
        value: 'en',
        label: '英语'
      }, {
        value: 'es',
        label: '西班牙语'
      }, {
        value: 'ja',
        label: '日语'
      }, {
        value: 'ko',
        label: '韩语'
      }, {
        value: 'ru',
        label: '俄语'
      }],
      value: ''
    }
  },
  watch: {
    question(newValue) {
      if (newValue === '') {
        this.answer = ''
      } else {
        this.getAnswer()
      }
    }
  },
  methods: {
    async getAnswer() {
      const requestData = {
        q: this.question,
        from: 'zh-CHS',
        to: this.value
      }
      try {
        const response = await translate(requestData)
        const str = response.data
        this.answer = str.replace(/^\["|"\]$/g, '')
      } catch (error) {
        console.error(error)
      }
    }
  }
}

</script>

<style scoped>
.container {
  display: flex;
  justify-content: space-between;
}

.app-container {
  flex: 1;
  margin: 10px;
  text-align: center;
}

.line {
  text-align: center;
}
.select-container{
  flex: 1;
  margin-top: 10px;
  height: 20px;
}
</style>

