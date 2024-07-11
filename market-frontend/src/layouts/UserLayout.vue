<template>
  <div id="userLayout">
    <a-layout style="height: 100vh">
      <a-layout-header class="header">
        <a-space>
          <img class="logo" src="../assets/appmarketlogo.jpg" />
          <div>海豚APP市场</div>
        </a-space>
        <div>您可以在此定制或使用他人发布的答题应用</div>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        <a
          href="https://blog.csdn.net/XhThT?spm=1011.2415.3001.5343"
          target="_blank"
        >
          by 海豚掀奶泡
        </a>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
#userLayout {
  text-align: center;
  background: url("https://gw.alipayobjects.com/zos/rmsportal/FfdJeJRQWjEeGTpqgBKj.png")
    0% 0% / 100% 100%;
}

.logo {
  width: 60px;
  height: 60px;
}

.header {
  margin-top: 16px;
  font-size: 21px;
}

.content {
  margin-bottom: 28px;
  padding: 20px;
}

.footer {
  padding: 16px;
  text-align: center;
  text-decoration: none;
  background: #efefef;
}
</style>
