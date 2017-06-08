# qiniu-sdk
封装七牛的上传sdk，适配到spring调用 在spring里面 扫面com.git.yi包
ByteUploadUtil 字节上传
InputStreamUploadUtil 流上传
PathUploadUtil 文件路径上传
具体的配置需要添加一下的配置参数
git.qiniu.accessKey= 访问key
git.qiniu.secretKey= 秘钥key 需要生成
git.qiniu.zero= 七牛机房位置
0 华东机房
1 华北机房
2 华南机房
上传对象中bucket 是你需要上传到那个七牛的路劲，必须填写

demo
application.yml
git:
    qiniu:
        accessKey: ***************************************
        secretKey: ***************************************
        zero: 2

test
@Autowired
    private PathUploadManager pathUploadManager;
    @RequestMapping("/test")
    public String tt(){
        PathVo pathVo = new PathVo();
        pathVo.setFilePath("/home/yidadi/teacher-avatar.png");
        pathVo.setFileName("test.jpg");
        return pathUploadManager.upload(pathVo);
    }