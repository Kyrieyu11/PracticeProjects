<script>
import { mapGetters } from 'vuex'
import IndexTodo from '@/views/dashboard/indexTodo.vue'
export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name',
      'gender',
      'userId',
      'position',
      'deptName'
    ])
  },
  components: { IndexTodo },
  data() {
    return {
      src: require('@/assets/avatar/Aavtar.jpg'),
      isHovering: false
    }
  }
}
</script>
<template>
  <el-container>
    <el-main>
      <!-- <el-row>
        <el-col :span="13" style="width: 50%">
          <IndexTodo />
        </el-col>
        <el-col class="radius" :span="10">
            <el-image :src="src" :fit="fit" style="margin-top: 20px;" />
          <div class="container">
            <div class="divspan">
              <div style="flex:1; background-color: black;">12312</div>
              <div style="flex:1;  background-color: black;">12312</div>
            </div>
          </div>
          <el-row>
            <el-col :span="10">
              <div class="grid-content bg-purple">213</div>
            </el-col>
            <el-col :span="10">
              <div class="grid-content bg-purple-light">321</div>
            </el-col>
            <el-col :span="10">
              <div class="grid-content bg-purple">213</div>
            </el-col>
            <el-col :span="10">
              <div class="grid-content bg-purple-light">321</div>
            </el-col>
          </el-row>
        </el-col>
      </el-row> -->
      <div class="div1">
        <IndexTodo />
      </div>
      <div class="div2">
        <el-row style="flex: 1;">
          <el-col :span="24" style="height:150px; margin-top: 15px">
            <el-image :src="src" :fit="fit" />
          </el-col>
        </el-row>
        <el-row style="flex: 1;">
          <el-col :span="12">
            <div
              class="grid-content"
            >{{ name }}
            </div>
          </el-col>
          <el-col :span="12">
            <div
              class="grid-content"
            >{{ gender }}
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <div
              class="grid-content"
            >{{ deptName }}
            </div>
          </el-col>
          <el-col :span="12">
            <div
              class="grid-content"
            >{{ position }}
            </div>
          </el-col></el-row>
      </div>
    </el-main>
  </el-container>

</template>

<style lang="scss" scoped>
.div1 {
  flex: 1;
  /* 每个子div占据相同的空间 */
  /* 方便看到边界 */
  justify-content: center;
  align-items: center;
}

.div2 {
  /* 每个子div占据相同的空间 */
  flex: 1;
  justify-content: center;
  align-items: center;
  border-radius: 4px;
  box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.3);
}

.dashboard {
  &-container {
    height: 100%;
  }

  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}

.el-main {
  color: #333;
  line-height: 160px;
  margin-top: 10px;
  display: flex;
  height: 100%;
}

.el-image {
  border-radius: 50%;
  height: 150px;
}

.el-col {
  border-radius: 4px;
  text-align: center;
}

.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bgpurplelight {
  background: #e5e9f2;
}

.grid-content {
  display: flex;
  justify-content: center;
  /* 水平居中 */
  align-items: center;
  /* 垂直居中 */
  border-radius: 4px;
  height: 7em;
  font-size: medium;
}
</style>
