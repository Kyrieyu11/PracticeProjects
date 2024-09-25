<template>
  <div class="app-container">
    <el-input v-model="filterText" placeholder="Filter keyword" style="margin-bottom:30px;" />
    <el-tree ref="tree2" :data="data2" :filter-node-method="filterNode" class="filter-tree" default-expand-all />
  </div>
</template>

<script>
import { tree } from '@/api/tree'
export default {
  data() {
    return {
      filterText: '',
      data2: [],
      depts: [
        { deptId: 101, deptName: 'Dept1' },
        { deptId: 102, deptName: 'Dept2' },
        { deptId: 103, deptName: 'Dept3' }
      ]
    }
  },
  watch: {
    filterText(val) {
      this.$refs.tree2.filter(val)
    }
  },
  mounted() {
    this.getDeptUser()
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    async getDeptUser() {
      for (const deptObj of this.depts) {
        try {
          const response = await tree(deptObj.deptId)
          let newData = {
            id: deptObj,
            label: deptObj.deptName,
            children: []
          }
          response.data.forEach(responseObj => {
            newData.children.push({
              label: responseObj.name,
              position: responseObj.position
            })
          })
          this.data2.push(newData)
        }
        catch (error) {
          console.log(error)
        }
      }
    }
  }
}
</script>

