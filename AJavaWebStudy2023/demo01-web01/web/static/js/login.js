/* ========== login.js ========== */
/* 1. 主题初始化 */
const html   = document.documentElement;
const toggle = document.getElementById('themeToggle');
(function initTheme() {
    const saved = localStorage.getItem('theme');
    if (saved === 'dark') {
        html.setAttribute('data-theme', 'dark');
        if (toggle) toggle.textContent = '☀️';
    } else {
        html.removeAttribute('data-theme');
        if (toggle) toggle.textContent = '🌙';
    }
})();

/* 2. 主题切换 */
if (toggle) {
    toggle.addEventListener('click', () => {
        const isDark = html.hasAttribute('data-theme');
        if (isDark) {
            html.removeAttribute('data-theme');
            toggle.textContent = '🌙';
            localStorage.setItem('theme', 'light');
        } else {
            html.setAttribute('data-theme', 'dark');
            toggle.textContent = '☀️';
            localStorage.setItem('theme', 'dark');
        }
    });
}

/* 3. 登录表单提交 */
document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const username = e.target.username.value.trim();
    const password = e.target.password.value;

    if (!username || password.length < 6) {
        alert('请输入完整信息且密码≥6位');
        return;
    }

    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);

    try {
        const res  = await fetch('/demo01/userServlet', { method: 'POST', body: params });
        const data = await res.json(); // {success, msg, token, user}

        if (data.success) {
            localStorage.setItem('token', data.token);
            localStorage.setItem('user', JSON.stringify(data.user));
            location.href = 'dashboard.html';
        } else {
            alert('登录失败：' + data.msg);
        }
    } catch (err) {
        console.error(err);
        alert('网络异常，请稍后再试');
    }
});

/* 4. 密码显隐 */
const passInput = document.getElementById('pass');
const togglePass = document.getElementById('togglePass');
if (togglePass) {
    togglePass.addEventListener('click', () => {
        const type = passInput.type === 'password' ? 'text' : 'password';
        passInput.type = type;
        togglePass.textContent = type === 'password' ? '👁️' : '🙈';
    });
}